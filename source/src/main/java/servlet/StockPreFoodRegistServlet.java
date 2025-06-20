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

import dao.TblStockprefoodDao;
import dto.Result;
import dto.TblStockprefoodDto;

@WebServlet("/StockPreFoodRegistServlet")
public class StockPreFoodRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//tbl_stockprefoodに登録されているデータを取得
		TblStockprefoodDao dao = new TblStockprefoodDao();
	    List<TblStockprefoodDto> list = dao.selectAll();
	    request.setAttribute("prefoodList", list);
	    
	    // 保存食管理ページにフォワードする
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
	    
	    String userNumberStr = request.getParameter("userNumber");
	    int userNumber = 0;
	    if(userNumberStr != null && !userNumberStr.isEmpty()) {
	        userNumber = Integer.parseInt(userNumberStr);
	    }
		
		//エラーチェック
		if(("insert".equals(action) || "update".equals(action)) &&
			(prefoodName == null || prefoodName.isEmpty() ||  
			prefoodDateStr == null || prefoodDateStr.isEmpty() || 
			prefoodQuantityStr == null || prefoodQuantityStr.isEmpty() || 
			userNumberStr == null || userNumberStr.isEmpty())) {
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
				prefoodDao.update(prefoodDto);
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
