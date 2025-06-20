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
		if(prefoodName == null || prefoodName.isEmpty() ||  
			prefoodDateStr == null || prefoodDateStr.isEmpty() || 
			prefoodQuantityStr == null || prefoodQuantityStr.isEmpty() || 
			userNumberStr == null || userNumberStr.isEmpty()) {
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
			//登録処理
			prefoodDao.insert(prefoodDto);
			request.setAttribute("result", new Result("登録成功！", "保存食が登録されました。","/StockPreFoodRegistServlet"));
		} else if ("update".equals(action)) {
			//更新処理
			prefoodDao.update(prefoodDto);
			request.setAttribute("result", new Result("更新成功！", "保存食が更新されました。", "/StockPreFoodRegistServlet"));
		} else if ("delete".equals(action)){
			//削除処理
			prefoodDao.delete(prefoodDto);
			request.setAttribute("result", new Result("削除成功！", "保存食が更新されました。", "/StockPreFoodRegistServlet"));
		} else {//失敗
			request.setAttribute("result", new Result("操作失敗！", "操作に失敗しました。", "/StockPreFoodRegistServlet"));
		}
		doGet(request,response);
		
	}
		
}
