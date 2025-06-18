package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblLifehacklistDao;
import dto.TblLifehacklistDto;

@WebServlet("/LifeHackListServlet")
public class LifeHackListServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ライフハック登録ページにフォワードする
		
		//ライフハック一覧を表示する
		// 検索処理を行う
		TblLifehacklistDao lifeDao = new TblLifehacklistDao();
		List<TblLifehacklistDto> lifeList = lifeDao.select(new TblLifehacklistDto(0, "", "", ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("lifeList", lifeList);

		
		// jsp/LifeHackList.jspにアクセスされて防災ライフハックの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackList.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		
		
		//ライフハックお気に入り登録
		//成功時、jsp/LifeHackFavorite.jspにアクセスされる。
		
	}
}
