package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TblSafestampDao;
import dto.TblSafestampDto;

//Home.jspのフォームにaction="home"あれば問題なし
@WebServlet("/home")
public class HomeServlet extends CustomTemplateServlet {
	private static final long serialVersionUID = 1L;
	
	
	//ゲット
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//★★★★★★ステータス取得処理開始ここから★★★★★★
		// セッションから family_id,user_numberを取得、LoginServletと統一の名前
		HttpSession session = request.getSession();
		String familyId = (String) session.getAttribute("familyId");

		// 取得できなければログインページにリダイレクト
		/*if (familyId == null) {
			response.sendRedirect("Login.jsp");
			return;
		}
*/
		// DAOを使って該当データを取得 findByFamilyId(familyId)この部分はDAO完成後修正
		TblSafestampDao dao = new TblSafestampDao();
		List<TblSafestampDto> safestampList = dao.findWithNameByFamilyId(familyId);


		// JSPにデータを渡す
		////JSP内でこの変数名（EL式）を使っているか確認（<c:forEach var="s" items="${safestampList}">みたいな形）
		request.setAttribute("safestampList", safestampList);
		//ステータス取得処理ここまで
		
		
		// ホームページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
		dispatcher.forward(request, response);
		//★★★★★★ステータス取得処理終了ここまで★★★★★★
	}

	//ポスト
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// ★★★★★★ 投稿処理ここから ★★★★★★
		// パラメータ（ステータス）を取得2行目<select name="status"> などから送られてきた「選択されたステータス文字列」を受け取る。
	    request.setCharacterEncoding("UTF-8");
	    String status = request.getParameter("status");

	    // セッションから familyId や userNumber を取得、LoginServletのセッションに合わせて以下項目変更
	    //キー名は、LoginServlet 側の setAttribute() のキーと必ず一致している必要がある
	    // セッションから user_number を取得、LoginServletと統一の名前
	    HttpSession session = request.getSession();
	    String familyId = (String) session.getAttribute("familyId");
	    Integer userNumber = (Integer) session.getAttribute("userNumber");

	    // 安全チェック（セッション切れなど）
	    if (familyId == null || userNumber == null) {
	        response.sendRedirect("Login");
	        return;
	    }

	    // DTO作成
	    //TblSafestampDto クラスに、これらの setXXX() メソッドが正しくあるかを確認する必要あり
	    TblSafestampDto dto = new TblSafestampDto();
	    dto.setStatus(status);
	    dto.setFamilyId(familyId);
	    dto.setUserNumber(userNumber);

	    // DAOで登録
	    //TblSafestampDAO の insert メソッドが boolean を返すように設計されていれば、result は「成功かどうか」を表す
	    //これは DAO 側で例外処理などが正しくされていることが前提
	    TblSafestampDao dao = new TblSafestampDao();
	    boolean result;
	    TblSafestampDto existing = dao.selectByUserNumber(userNumber); // ← ①すでにあるかチェック

	    if (existing != null) {
	        // ②既存あり → 更新処理へ
	        dto.setSafeNumber(existing.getSafeNumber()); // ←更新対象の主キーをセット
	        result = dao.update(dto);
	    } else {
	        // ③なければ新規登録
	        result = dao.insert(dto);
	    }

	    

	    // 成功したら /home にリダイレクト、失敗したらサーバーのコンソールにエラー表示（仮）
	    //DAOの insert() メソッドが boolean を返す設計の時のみ有効
	    //TblSafestampDao.java を確認。
	    if (result) {
	        System.out.println("投稿に成功しました。");
	        response.sendRedirect("home");
	    } else {
	        System.out.println("投稿に失敗しました。エラー内容：投稿処理中に問題が発生しました。");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Home.jsp");
	        dispatcher.forward(request, response);
	    }
	    // ★★★★★★ 投稿処理ここまで ★★★★★★
	}

}

/*

 */

//Home.jsp,LoginServlet,TblSafestampDao,TblSafestampDto
//上記ファイル完成後キー名など調整し完成