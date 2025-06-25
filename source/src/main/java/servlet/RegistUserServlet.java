package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblCheckbagDao;
import dao.TblRegistuserDao;
import dao.TblSafestampDao;
import dto.Result;
import dto.TblRegistuserDto;
import dto.TblSafestampDto;
import utility.MailUtil;

@WebServlet("/RegistUserServlet")
public class RegistUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// セッションから familyId を取得してリクエストに渡す
	    String familyId = (String) request.getSession().getAttribute("familyId");
	    request.setAttribute("familyId", familyId);
		// ユーザー新規登録申請ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String familyId = request.getParameter("familyId");
		
		//入力値のセット
		request.setAttribute("mail", mail);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		request.setAttribute("familyId", familyId);
			
		boolean hasError = false;
		
		//エラーチェック1:未入力
		if (mail == null || password == null || name == null || familyId == null ||
		        mail.trim().isEmpty() || password.trim().isEmpty() || name.trim().isEmpty() || familyId.trim().isEmpty()) {
		        request.setAttribute("errorMessage", "全ての項目を入力してください。");
		        hasError = true;
		    }
		
		TblRegistuserDao registDao = new TblRegistuserDao();
		
		if (hasError) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
		dispatcher.forward(request, response);
		return;
		}
		
			
		//重複チェック1（メールアドレスが既に登録済みの場合）
		if (registDao.existsMail(mail)) {
			request.setAttribute("error", "このメールアドレスは既に登録されています。");
			request.setAttribute("mail", mail); // 入力保持
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		//重複チェック2（登録されていない家族IDが入力された場合）
		if (!registDao.existsFamilyId(familyId)) {
		    request.setAttribute("warning", "この家族IDは登録されていません。");
		    request.setAttribute("familyId", familyId); // 入力保持
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
			
		
		// 登録処理を行う
		if (registDao.insert(new TblRegistuserDto(0, mail, password, name, familyId))) { // 登録成功
			
			//ここからテンプレートコピー操作・安否確認初期値追加
			// userNumberを取得するため、登録したユーザーを再取得
		    TblRegistuserDto insertedUser = registDao.selectByMail(mail);
		    if (insertedUser != null) {
		        int userNumber = insertedUser.getUserNumber();

		        // TblCheckbagDaoのインスタンス作成
		        TblCheckbagDao checkbagDao = new TblCheckbagDao();

		        // テンプレートコピー実行
		        boolean copied = checkbagDao.copyTemplateForUser(userNumber);
		        if (!copied) {
		            System.err.println("テンプレートコピーに失敗しました。");
		            // 必要に応じてエラー処理を追加
		        }
		        
		        // safetamp への初期値登録を追加
		        TblSafestampDao safestampDao = new TblSafestampDao();
		        TblSafestampDto safestampDto = new TblSafestampDto();
		        safestampDto.setStatus("安全です");
		        safestampDto.setFamilyId(familyId);
		        safestampDto.setUserNumber(userNumber);

		        boolean safeInserted = safestampDao.insert(safestampDto);
		        if (!safeInserted) {
		            System.err.println("safestamp 登録に失敗しました。");
		        }
		        
		        
		        
		    } else {
		        System.err.println("登録したユーザー情報の取得に失敗しました。");
		        // 必要に応じてエラー処理を追加
		    }
			//ここまで
			
			// ログインページにリダイレクトする
			response.sendRedirect(request.getContextPath() + "/login");
		} else { // 登録失敗
			request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/webapp/RegistUserServlet"));
			// ユーザー登録ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
			dispatcher.forward(request, response);
		}
		
		MailUtil.sendMail("horii-kosei-plusdojo2025@seplus2016.onmicrosoft.com", "【登録完了】防災管理アプリへようこそ", """


このたびは、防災管理アプリにご登録いただき、誠にありがとうございます。
ご登録が正常に完了いたしましたので、ご案内申し上げます。

本アプリでは、以下のような機能を通じて、日々の防災対策をサポートいたします。

・備蓄品の在庫管理
・保存食の賞味期限チェック
・緊急時にも役立つライフハックの紹介
・ハザードマップの確認
・現在の防災・気象情報の表示

アプリのご利用を開始するには、以下のリンクよりログインしてください：
👉 http://localhost:8080/C2/login
ご不明な点やご質問がございましたら、以下のサポート窓口までお気軽にご連絡ください。
──────────────────
防災管理アプリ サポートセンター
メール：support@example.jp
電話：03-XXXX-XXXX（平日9:00～18:00）
──────────────────
今後とも、防災管理アプリをどうぞよろしくお願いいたします。
皆さまの安全・安心な暮らしを、心より願っております。
防災管理アプリ運営チーム


				""");
		
	}
}
