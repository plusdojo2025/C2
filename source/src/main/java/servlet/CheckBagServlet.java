package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TblCheckbagDao;
import dto.IdPw;
import dto.TblCheckbagDto;


@WebServlet("/CheckBagServlet")
public class CheckBagServlet extends CustomTemplateServlet {
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
		    }
		
		// 防災バッグリストページにフォワードする
		//データベースからユーザーIDが一致しているデータを取得する
	

//		セッションスコープからuserNumberを取り出す
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		

		
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
		
		
//		セッションスコープからuserNumberを取り出す
		HttpSession session = request.getSession();
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		

		
		// リクエストパラメータを取得する
		//Boolean型のパラメーター取得(1回変数に代入して、Boolean型に変換)
		String[] checkedBagNumbers = request.getParameterValues("checkBag[]");
		
		//int型のパラメーター取得(1回変数に代入して、int型に変換)
		String[] num2 = request.getParameterValues("bagStock[]"); 
		int[] argbagStock = new int[num2.length];
		String[] num3 = request.getParameterValues("bagNumber[]");
		int[] argbagNumber = new int[num3.length];
		
		for (int i = 0; i < num2.length; i++) {
			argbagStock[i] = Integer.parseInt(num2[i]);
			argbagNumber[i] = Integer.parseInt(num3[i]);
		}
		
		
		//String型のパラメーター取得
		String[] argbagName = request.getParameterValues("bagname[]");
		String[] argbagLink = request.getParameterValues("link[]");
		
		
		  // チェックボックスのチェック判定に使うため、セットに変換 
		Set<String> checkedSet = new HashSet<>();
		if(checkedBagNumbers != null) {
		  checkedSet.addAll(Arrays.asList(checkedBagNumbers)); }
		 
		//データベースを更新
		for(int i= 0; i<argbagName.length; i++) {
			int Number = argbagNumber[i];
		    Boolean check = checkedSet.contains(String.valueOf(Number));
			int bagStock = argbagStock[i];
			int bagNumber = argbagNumber[i];
			String bagName = argbagName[i];
			String bagLink = argbagLink[i];
			TblCheckbagDao dao = new TblCheckbagDao();
			TblCheckbagDto TblCheckbagDto = new TblCheckbagDto(bagNumber, check, bagName, bagStock, bagLink, userNumber);
			boolean result = dao.update(TblCheckbagDto);
			
		}
		
		TblCheckbagDao dao = new TblCheckbagDao();
		List<TblCheckbagDto> checkBag = dao.select(new TblCheckbagDto(0, false, "", 0,"" , userNumber));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("checkBag", checkBag);
				
				
		// jsp/CheckBag.jspにアクセスされて防災バッグリストの画面が表示される
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CheckBag.jsp");
		dispatcher.forward(request, response);
		
		/*
		 * if (dao.update(new TblCheckbagDto(bagNumber, check, bagName, bagStock,
		 * bagLink, userNumber))) {
		 * 
		 * 
		 * List<TblCheckbagDto> checkBag = dao.select(new TblCheckbagDto(0, false, "",
		 * 0,"" , userNumber));
		 * 
		 * // 検索結果をリクエストスコープに格納する request.setAttribute("checkBag", checkBag);
		 * 
		 * // jsp/CheckBag.jspにアクセスされて防災バッグリストの画面が表示される RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/WEB-INF/jsp/CheckBag.jsp");
		 * dispatcher.forward(request, response); 
		 * } else { 
		 * System.out.println("更新失敗！");
		 * }
		 */
		
	}
}