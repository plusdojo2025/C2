package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (checkDoneLogin(request,response)) {
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
		if (checkDoneLogin(request,response)) {
			return;
		}
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		response.sendRedirect("home");
		
		
		
		// リクエストパラメーターを取得する
		//request.setCharacterEncoding("UTF-8");
		//String mail = request.getParameter("mail");
		//String pw = request.getParameter("pw");

		// ログイン処理を行う
		// インスタンス化する
		/*TblRegistuserDao iDao = new TblRegistuserDao();
		
		TblRegistuserDto ip = new TblRegistuserDto(mail, pw);
		boolean ans = iDao.isLoginOK(ip);

		if (ans) {
			// if (iDao.isLoginOK(new IdPw(id, pw))) { // ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new LoginUser("mail"));

			// メニューサーブレットにリダイレクトする
			// 他のページをリクエストされたからフォワードではなくリダイレクト
			response.sendRedirect("/webapp/MenuServlet");
		} else { // ログイン失敗
					// リクエストスコープに、メールアドレス、パスワード、戻り先を格納する
			// request.setAttribute("result", new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/webapp/LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
		}

		// 家族IDを新しく作成するリンク
		/*
		@WebServlet("/RegistFamily")
		public class RegistFamily extends CustomTemplateServlet {
			private static final long serialVersionUID = 1L;


			// doGet
			@Override
			protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				// jsp/RegistFamily.jspにフォワード（アクセスされて家族ID新規登録の画面が表示される）
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistFamily.jsp");
				dispatcher.forward(request, response);
			}
			// ユーザー情報を新しく作成するリンク
			@WebServlet("/RegistUser")
			public class RegistUser extends CustomTemplateServlet {
				private static final long serialVersionUID = 1L;

				// doGet
				@Override
				protected void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					// jsp/RegistFamily.jspにフォワード（アクセスされて家族ID新規登録の画面が表示される）
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
					dispatcher.forward(request, response);
*/
			//	}
			//}
		//}
	}
}
