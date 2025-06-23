package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblRegistfamilyDao;
import dto.Result;
import dto.TblRegistfamilyDto;

@WebServlet("/RegistFamilyServlet")
public class RegistFamilyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 家族ID登録ページにフォワードする
		// jsp/RegistFamily.jspにアクセスされて家族ID登録の画面が表示される
		
		request.removeAttribute("familyId");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistFamily.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String familyId = request.getParameter("familyId");
		
		//エラーチェック
		//空文字ornullチェック
		if(familyId==null || familyId.trim().isEmpty()) {
			request.setAttribute("error","家族IDを入力してください。");
			
			request.setAttribute("familyId", familyId);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistFamily.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//重複チェック
		TblRegistfamilyDao registDao = new TblRegistfamilyDao();
		if (registDao.exists(familyId)) {
			request.setAttribute("error", "この家族IDは既に登録されています。");
			request.setAttribute("familyId", familyId); // 入力保持
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistFamily.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// 登録処理を行う
			if (registDao.insert(new TblRegistfamilyDto(familyId))) { // 登録成功
				// セッションに登録済みの familyId を保存
			    request.getSession().setAttribute("familyId", familyId);
			    // ユーザー登録ページにリダイレクトする
				response.sendRedirect(request.getContextPath() + "/RegistUserServlet");
			} else { // 登録失敗
				request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/webapp/RegistFamilyServlet"));
				// 家族ID登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/RegistFamily.jsp");
				dispatcher.forward(request, response);
			}
	}
	
}
