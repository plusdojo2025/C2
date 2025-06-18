package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblRegistuserDao;
import dto.Result;
import dto.TblRegistuserDto;

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
		
		//エラーチェック
		if(mail==null || password==null || name==null || familyId==null) {
			request.setAttribute("登録失敗！","全ての項目を入力してください。");
			
			request.setAttribute("mail", mail);
			request.setAttribute("password", password);
			request.setAttribute("name", name);
			request.setAttribute("familyId", familyId);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// 登録処理を行う
		TblRegistuserDao registDao = new TblRegistuserDao();
		if (registDao.insert(new TblRegistuserDto(0, mail, password, name, familyId))) { // 登録成功
			// ログインページにリダイレクトする
			response.sendRedirect(request.getContextPath() + "/login");
		} else { // 登録失敗
			request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/webapp/RegistUserServlet"));
			// ユーザー登録ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistUser.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}
