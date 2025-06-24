package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TblLifehackfavoriteDao;
import dao.TblLifehacklistDao;
import dto.TblLifehackfavoriteDto;
import dto.TblLifehacklistDto;


@WebServlet("/LifeHackListServlet")
public class LifeHackListServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ライフハック登録ページにフォワードする
		
		// ── 検索キーワード取得 ──(キーワードがない場合空文字)
		String keyword = request.getParameter("keyword");
        if (keyword == null) keyword = "";
        
        
		//ライフハック一覧を表示する
		// 検索処理を行う
		TblLifehacklistDao lifeDao = new TblLifehacklistDao();
		List<TblLifehacklistDto> lifeList = lifeDao.select(new TblLifehacklistDto(0, keyword, "", ""));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("lifeList", lifeList);
		
		//お気に入りIDリスト玉川追加
		HttpSession session = request.getSession();
	    String familyId = (String) session.getAttribute("familyId");
	    TblLifehackfavoriteDao favDao = new TblLifehackfavoriteDao();
	    List<Integer> favoriteNumbers = favDao.selectLifehackNumbersByFamilyId(familyId);
	    //JSPに渡す玉川追加
	    request.setAttribute("lifeList", lifeList);
	    request.setAttribute("favoriteNumbers", favoriteNumbers);
	   
		
		// jsp/LifeHackList.jspにアクセスされて防災ライフハックの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackList.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		
		String num2 = request.getParameter("lifehackNumber"); 
		int lifehackNumber = Integer.parseInt(num2);
		
		
		//ライフハックお気に入り登録
		HttpSession session = request.getSession();
		String FamilyId = (String) session.getAttribute("familyId");
		
		TblLifehackfavoriteDto dto = new TblLifehackfavoriteDto(0, FamilyId, lifehackNumber);
		
		// データの処理を行うためのDAOのインスタンスを生成
		TblLifehackfavoriteDao dao = new TblLifehackfavoriteDao();
		
		
		//成功時、jsp/LifeHackFavorite.jspにアクセスされる。
	
			if (dao.insert(dto)) {
				//ライフハック一覧を表示する
				// 検索処理を行う
				TblLifehacklistDao lifeDao = new TblLifehacklistDao();
				List<TblLifehacklistDto> lifeList = lifeDao.select(new TblLifehacklistDto(0, "", "", ""));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("lifeList", lifeList);
//玉川追加
				TblLifehackfavoriteDao favDao = new TblLifehackfavoriteDao();
				List<Integer> favoriteNumbers = favDao.selectLifehackNumbersByFamilyId(FamilyId);
				request.setAttribute("favoriteNumbers", favoriteNumbers);
//玉川追加				
				// jsp/LifeHackList.jspにアクセスされて防災ライフハックの画面が表示される
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackList.jsp");
				dispatcher.forward(request, response);
			}else {RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackList.jsp");
			dispatcher.forward(request, response);
			}
	}
}
