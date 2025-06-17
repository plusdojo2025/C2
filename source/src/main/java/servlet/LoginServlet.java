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
		// 強制的にログアウトさせる
		session.invalidate();
		if (checkDoneLogin(request, response)) {
			return;
		}
		// ログインページにフォワードする
		// jsp/Login.jspにアクセスされてログインの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	// ユーザーがmailとpwのリクエストを送信
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * // ログインしている場合はログイン処理を飛ばす 
		 * if (checkDoneLogin(request,response)) { return; }
		 */
		request.setCharacterEncoding("UTF-8");
		// mailとpwを入力しリクエストパラメーターを取得する
		String mail = request.getParameter("mailaddress");
		String pw = request.getParameter("pw");

		// データの処理を行うためのDAOのインスタンスを生成
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
			// 強制的にログアウトさせる
			session.invalidate();
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
/*
 * // メールアドレスが入力されていなかった時 if (mail == null) { HttpSession session =
 * request.getSession(); session.setAttribute("mail", mail ); // ホームにリダイレクト
 * response.sendRedirect("/WEB-INF/jsp/Home.jsp"); // ログイン失敗 } else { //
 * リクエストスコープに、タイトル、メッセージを格納する request.setAttribute("errormsg" ,
 * "メールアドレスを入力してください。"); } // パスワードが入力されてなかった時 if (pw == null) { HttpSession
 * session = request.getSession(); session.setAttribute("password", pw ); //
 * ホームにリダイレクト response.sendRedirect("/WEB-INF/jsp/Home.jsp"); // ログイン失敗 } else {
 * // リクエストスコープに、タイトル、メッセージを格納する request.setAttribute("errormsg" ,
 * "パスワードを入力してください。"); }
 */
