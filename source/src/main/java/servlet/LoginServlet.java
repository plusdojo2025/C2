package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TblRegistuserDao;
import dto.IdPw;

// ログインサーブレットがURLであるloginと対応している
@WebServlet("/login")
public class LoginServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// ログインページにフォワードする
		// jsp/Login.jspにアクセスされてログインの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	// ユーザーがmailとpwのリクエストを送信
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// mailとpwを入力しリクエストパラメーターを取得する
		
		  String mail = request.getParameter("mailaddress"); 
		  String pw = request.getParameter("pw");
		 
//		String mail ="Jin0909@gmail.com";
//		String pw ="Satake09";Wakusei03

		 //データの処理を行うためのDAOのインスタンスを生成
		TblRegistuserDao dao = new TblRegistuserDao();
		// メールアドレスとパスワードをDTOにまとめる
		IdPw idpw = new IdPw(mail, pw);
		// 入力されたメールアドレスとパスワードが正しいかどうかの確認
		boolean result = dao.insert(idpw);
		
		
		// Login.jspにログインする
		// ログインに成功した場合
		
		if (result) {
			// セッションオブジェクトを取得
			HttpSession session = request.getSession();

			// ユーザーの情報をセッションに保存
			session.setAttribute("mail", idpw);
			// ホームサーブレットにリダイレクト
			response.sendRedirect("home");
			// ログインに失敗した場合
		} else {
			request.setAttribute("error", "メールアドレスまたはパスワードが違います。");
			// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}

