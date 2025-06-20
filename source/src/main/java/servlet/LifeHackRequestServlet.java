package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblLifehackrequestDao;
import dto.TblLifehackrequestDto;

//ライフハック申請サーブレットがURLであるLifeHackRequestと対応している
@WebServlet("/LifeHackRequest")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,    // 1MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 20    // 20MB
	)
public class LifeHackRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// get
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ライフハック申請ページにフォワードする
		// jsp/LifeHackRequest.jspにアクセスされてライフハック申請ページの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackRequest.jsp");
		dispatcher.forward(request, response);
	}

	// post
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータを取得する
		String title = request.getParameter("title");
		String photo = request.getParameter("lifehackimg");
		String textline = request.getParameter("explanation");
		
		// データの処理を行うためのDTOのインスタンスを生成
		TblLifehackrequestDto dto = new TblLifehackrequestDto(0, title, photo,textline);
		dto.setTitle(title);
		dto.setPhoto(photo);	
		dto.setTextline(textline);
		
		// データの処理を行うためのDAOのインスタンスを生成
		TblLifehackrequestDao dao = new TblLifehackrequestDao();
		
		// 申請処理を行う
			if (dao.insert(dto)) { // 申請成功
				// ユーザー登録ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackRequest.jsp");
				dispatcher.forward(request, response);
			} else { // 申請失敗
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackRequest.jsp");
				dispatcher.forward(request, response);
			
			}
		}
}
