package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchMapServlet")
public class SearchMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// セッションから family_id,user_numberを取得、LoginServletと統一の名前
			HttpSession session = request.getSession(false);
			// セッションから familyId を取得
			if (session == null) {
		        // 未ログイン時の処理（ログイン画面へリダイレクト）
		        response.sendRedirect("login");
		        return;
		    }
			
			String mailaddress = (String) session.getAttribute("mailaddress"); 
			// セッション用のメールアドレスにメールアドレスが入っているか確認する
			System.out.println("mailaddress:" + mailaddress);
			
			if (mailaddress == null) {
		        // 未ログイン時の処理（ログイン画面へリダイレクト）
		        response.sendRedirect("login");
		        return;
		    }
			// ハザードマップ検索ページにフォワードする
			// jsp/SearchMap.jspにアクセスされてハザードマップ検索ページの画面が表示される
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SearchMap.jsp");
			dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
