package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TblStockprefoodDao;
import dto.Result;
import dto.TblStockprefoodDto;

@WebServlet("/StockPreFoodRegistServlet")
public class StockPreFoodRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 保存食管理ページにフォワードする
		//データベースからユーザーIDが一致しているデータを取得する
		
		//ログインのセッションが完成したら動作する
		//セッションスコープからuserNumberを取り出す
		HttpSession session = request.getSession();
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		
		//tbl_stockprefoodに登録されているデータを取得
		//userNumberが一緒のデータを検索して全てリストに表示する
		TblStockprefoodDao dao = new TblStockprefoodDao();
	    List<TblStockprefoodDto> list = dao.select(new TblStockprefoodDto(0, "", null, 0 ,userNumber));

	    //検索結果をリクエストスコープに格納する
	    request.setAttribute("prefoodList", list);
	    
	    
	    // jsp/StockPreFoodRegist.jspにアクセスされて保存食管理ページの画面が表示される
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/StockPreFoodRegist.jsp");
	 	dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		//セッションからユーザー番号を取得
		HttpSession session = request.getSession();
	    Integer userNumber = (Integer) session.getAttribute("userNumber");
		
		//パラメータ取得
		String prefoodNumberStr = request.getParameter("prefoodNumber");
	    int prefoodNumber = 0;
	    if(prefoodNumberStr != null && !prefoodNumberStr.isEmpty()) {
	        prefoodNumber = Integer.parseInt(prefoodNumberStr);
	    }
	    
	    System.out.println("action: " + action);
	    System.out.println("prefoodNumber: " + prefoodNumber);
	    
		String prefoodName = request.getParameter("prefoodName");
		
		String prefoodDateStr = request.getParameter("prefoodDate");
	    Date prefoodDate = null;
	    if(prefoodDateStr != null && !prefoodDateStr.isEmpty()) {
	        prefoodDate = Date.valueOf(prefoodDateStr);
	    }
	    
	    int prefoodQuantity = 0;
		String prefoodQuantityStr = request.getParameter("prefoodQuantity");
		if (prefoodQuantityStr != null && !prefoodQuantityStr.isEmpty()) {
			prefoodQuantity = Integer.parseInt(prefoodQuantityStr);
		}
		
		//エラーチェック
		if(("insert".equals(action) || "update".equals(action)) &&
			(prefoodName == null || prefoodName.isEmpty() ||  
			prefoodDateStr == null || prefoodDateStr.isEmpty() || 
			prefoodQuantityStr == null || prefoodQuantityStr.isEmpty())) {
			
			request.setAttribute("error","全ての項目を入力してください。");
			request.setAttribute("prefoodName", prefoodName);
			request.setAttribute("prefoodDate", prefoodDate);
			request.setAttribute("prefoodQuantity", prefoodQuantity);
			request.setAttribute("userNumber", userNumber);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/StockPreFoodRegist.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		
		
		
		
		TblStockprefoodDao prefoodDao = new TblStockprefoodDao();
		TblStockprefoodDto prefoodDto = new TblStockprefoodDto(prefoodNumber, prefoodName, prefoodDate, prefoodQuantity, userNumber);
		
		if ("insert".equals(action)) { // 登録成功
				prefoodDao.insert(prefoodDto);
				response.sendRedirect(request.getContextPath() + "/StockPreFoodRegistServlet");
			    return;
		} else if ("update".equals(action)) {
				prefoodDao.update(prefoodDto);
				response.sendRedirect(request.getContextPath() + "/StockPreFoodRegistServlet");
			    return;
		} else if ("delete".equals(action)){
				// 削除処理を呼び出す
			boolean success = prefoodDao.delete(prefoodDto);
		    	if(success) {
		    		response.sendRedirect(request.getContextPath() + "/StockPreFoodRegistServlet");
		    		return;
		    	} else {//失敗
			System.err.println("削除失敗 prefoodNumber=" + prefoodNumber);
			request.setAttribute("result", new Result("操作失敗！", "操作に失敗しました。", "/StockPreFoodRegistServlet"));
		    }
		}
	}
}
