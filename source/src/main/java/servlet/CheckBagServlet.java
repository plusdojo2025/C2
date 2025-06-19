package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblCheckbagDao;
import dto.TblCheckbagDto;


@WebServlet("/CheckBagServlet")
public class CheckBagServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 防災バッグリストページにフォワードする
		//データベースからユーザーIDが一致しているデータを取得する
	
//		ログインのセッションが完成したら動作する
//		セッションスコープからuserNumberを取り出す
//		HttpSession session = request.getSession();
//		Integer userNumber = (Integer)session.getAttribute("userNumber");
		
		int userNumber = 1;
		
		//userNumberが一緒のデータを検索して全てリストに追加する
		TblCheckbagDao dao = new TblCheckbagDao();
		List<TblCheckbagDto> checkBag = dao.select(new TblCheckbagDto(0, false, "", 0,"" , userNumber));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("checkBag", checkBag);
				
				
		// jsp/CheckBag.jspにアクセスされて防災バッグリストの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckBag.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータを取得する
		//Boolean check = request.getParameter("cheakBag");
		//String photo = request.getParameter("lifehackimg");
	}
}