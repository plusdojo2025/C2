package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TblLifehackrequestDao;
import dto.Result;
import dto.TblLifehackrequestDto;

//ライフハック申請サーブレットがURLであるLifeHackRequestと対応している
@WebServlet("/LifeHackRequest")
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
		int registnumber = Integer.parseInt(request.getParameter("registnumber"));
		String title = request.getParameter("title");
		String photo = request.getParameter("photo");
		String textline = request.getParameter("textline");
		
		/*
		// セッションからmailaddressを取得
		// 40,41,44はHomeServletに沿って作成中のため、HomeServlet変更後こちらも変更が必要
		HttpSession session = request.getSession();
		String familyid = (String) session.getAttribute("family_id");
		Integer usernumber = (Integer) session.getAttribute("user_number");

		// セッション切れ防止
		if (familyid == null || usernumber == null) {
			response.sendRedirect("Login");
			return;
		}*/
		
		// データの処理を行うためのDTOのインスタンスを生成
		TblLifehackrequestDto dto = new TblLifehackrequestDto();
		dto.setRegistNumber(registnumber);
		dto.setTitle(title);
		dto.setPhoto(photo);	
		dto.setTextline(textline);
		

		// データの処理を行うためのDAOのインスタンスを生成
		TblLifehackrequestDao dao = new TblLifehackrequestDao();
		boolean result = dao.insert(dto);
		
		// 申請処理を行う
			if (dao.insert(new TblLifehackrequestDto(0, title, photo,textline))) { // 申請成功
				request.setAttribute("result", new Result("complete", "申請完了しました。", "LifeHackRequest"));
			} else { // 申請失敗
				request.setAttribute("result", new Result("error", "未入力の項目があります。", "/WEB-INF/jsp/LifeHackRequest.jsp"));
			}
/*
		// 申請完了したらLifeHackRequestServletにリダイレクト
		if (result) {
			System.out.println("申請完了しました。");
			response.sendRedirect("LifeHackRequest");
		} else {
			// エラーを表示
			System.out.println("未入力の項目があります。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LifeHackRequest.jsp");
			dispatcher.forward(request, response);
			*/
		}
	}
