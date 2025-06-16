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
		/*
		String action = request.getParameter("action");	
		if ("RegistFamily".equals(action)) {
	        // 画面遷移（リダイレクト）
	        response.sendRedirect("RegistFamily.jsp");
	    } else {
	        // 通常の処理や初期表示
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
	        dispatcher.forward(request, response);
	    }
		*/
		
		// idとpwを入力する
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		response.sendRedirect("home");
		
			// ログインページにフォワードする
			// jsp/Login.jspにアクセスされてログインの画面が表示される
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
		}
	}
