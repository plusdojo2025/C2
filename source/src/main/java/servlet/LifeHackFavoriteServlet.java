package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TblLifehackfavoriteDao;
import dto.TblLifehackfavoriteDto;


@WebServlet("/LifeHackFavoriteServlet")
public class LifeHackFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//一覧取得処理ここから
	    // セッションから familyId を取得
	    HttpSession session = request.getSession(false);
	    String familyId = (String) session.getAttribute("familyId");

	    if (familyId == null) {
	        // 未ログイン時の処理（ログイン画面へリダイレクト）
	        response.sendRedirect("login");
	        return;
	    }

	    // DAOとDTOの用意
	    TblLifehackfavoriteDao dao = new TblLifehackfavoriteDao();
	    TblLifehackfavoriteDto dto = new TblLifehackfavoriteDto();
	    dto.setFamilyId(familyId);

	    // ★ familyIdを使ってお気に入りを全件取得する新しいメソッドが必要です ★
	    // → 今のDAOは「favoriteNumber指定」でしか select できないので、新メソッドを追記してください
	    List<TblLifehackfavoriteDto> favoriteList = dao.selectByFamilyId(dto); // 仮想のメソッド名

	    
	    
	    System.out.println("★ familyId: " + familyId);

	    if (favoriteList == null) {
	        System.out.println("★ favoriteList is null");
	    } else if (favoriteList.isEmpty()) {
	        System.out.println("★ favoriteList is empty");
	    } else {
	        System.out.println("★ favoriteList size: " + favoriteList.size());

	        TblLifehackfavoriteDto first = favoriteList.get(0);
	        if (first.getLifehack() != null) {
	            System.out.println("★ title: " + first.getLifehack().getTitle());
	            System.out.println("★ photo: " + first.getLifehack().getPhoto());
	            System.out.println("★ textline: " + first.getLifehack().getTextline());
	        } else {
	            System.out.println("★ first.getLifehack() is null");
	        }
	    }

	    
	    
	    
	    
	    // リクエストスコープにセット
	    request.setAttribute("favoriteList", favoriteList);
		//一覧取得処理ここまで
		
		// ライフハックお気に入り登録ページにフォワードする
		// jsp/LifeHackFavorite.jspにアクセスされて防災バッグリストの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackFavorite.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// セッションから familyId を取得
	    HttpSession session = request.getSession(false);
	    String familyId = (String) session.getAttribute("familyId");
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		
		String num2 = request.getParameter("lifehackfavoriteNumber"); 
		int lifehackfavoriteNumber = Integer.parseInt(num2);
		
		TblLifehackfavoriteDto dto = new TblLifehackfavoriteDto(lifehackfavoriteNumber, familyId, 0);
		
		// データの処理を行うためのDAOのインスタンスを生成
		TblLifehackfavoriteDao dao = new TblLifehackfavoriteDao();
		

		
		//成功時、jsp/LifeHackFavorite.jspにアクセスされる。
		
		if (dao.delete(dto)) {
			List<TblLifehackfavoriteDto> favoriteList = dao.selectByFamilyId(dto); // 仮想のメソッド名

		    
		    
		    System.out.println("★ familyId: " + familyId);

		    if (favoriteList == null) {
		        System.out.println("★ favoriteList is null");
		    } else if (favoriteList.isEmpty()) {
		        System.out.println("★ favoriteList is empty");
		    } else {
		        System.out.println("★ favoriteList size: " + favoriteList.size());

		        TblLifehackfavoriteDto first = favoriteList.get(0);
		        if (first.getLifehack() != null) {
		            System.out.println("★ title: " + first.getLifehack().getTitle());
		            System.out.println("★ photo: " + first.getLifehack().getPhoto());
		            System.out.println("★ textline: " + first.getLifehack().getTextline());
		        } else {
		            System.out.println("★ first.getLifehack() is null");
		        }
		    }
 
		    
		    // リクエストスコープにセット
		    request.setAttribute("favoriteList", favoriteList);
			//一覧取得処理ここまで
			
			// ライフハックお気に入り登録ページにフォワードする
			// jsp/LifeHackFavorite.jspにアクセスされて防災バッグリストの画面が表示される
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackFavorite.jsp");
			dispatcher.forward(request, response);
			
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackFavorite.jsp");
		    dispatcher.forward(request, response);
		}
	}
}
