package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.IdPw;

@WebServlet("/SearchMapServlet")
public class SearchMapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// セッションから family_id,user_numberを取得、LoginServletと統一の名前
	// 必ずセッションを取得（なければ作成）
			HttpSession session = request.getSession(true);
			
			IdPw idpw = (IdPw) session.getAttribute("mail"); 
			// idpw があればメールを取り出し、なければ null にする
			String mail = (idpw != null) ? idpw.getMail() : null;
			// セッション用のメールアドレスにメールアドレスが入っているか確認する
			System.out.println("mail:" + mail);
			
			if (mail == null) {
		        // 未ログイン時の処理（ログイン画面へリダイレクト）
				// ログインしていないと判断した時の処理
		        response.sendRedirect(request.getContextPath() + "/login");
		        return;
		    } else {
			// ハザードマップ検索ページにフォワードする
			// jsp/SearchMap.jspにアクセスされてハザードマップ検索ページの画面が表示される
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SearchMap.jsp");
			dispatcher.forward(request, response);
		  }
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
