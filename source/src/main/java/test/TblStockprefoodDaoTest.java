package test;
import java.sql.Date;
import java.util.List;

import dao.TblStockprefoodDao;
import dto.TblStockprefoodDto;

public class TblStockprefoodDaoTest {

	private static final Date date = null;

	public static void showAllData(List<TblStockprefoodDto> prefoodList) {
		for (TblStockprefoodDto prefood : prefoodList) {
			System.out.println("保存食番号：" + prefood.getPrefoodNumber());
			System.out.println("保存食名：" + prefood.getPrefoodName());
			System.out.println("保存食期限：" + prefood.getPrefoodDate());
			System.out.println("数量" + prefood.getPrefoodQuantity());
			System.out.println("ユーザー番号：" + prefood.getUserNumber());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TblStockprefoodDao dao = new TblStockprefoodDao();
		
/*		
	// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<TblStockprefoodDto> cardListSel1 = dao.select(new TblStockprefoodDto(1,"",date,0,0));
		TblStockprefoodDaoTest.showAllData(cardListSel1);
		
	// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<TblStockprefoodDto> cardListSel2 = dao.select(new TblStockprefoodDto(2,"",date,0,0));
		TblStockprefoodDaoTest.showAllData(cardListSel2);
	
		
	// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		java.sql.Date date = Date.valueOf("2026-06-07");
		TblStockprefoodDto insRec = new TblStockprefoodDto(0,"パックご飯",date,0,2);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<TblStockprefoodDto> cardListIns = dao.select(new TblStockprefoodDto(0, "", date,0,0));
			TblStockprefoodDaoTest.showAllData(cardListIns);
		} else {
			System.out.println("登録失敗！");
		}
		
	// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		List<TblStockprefoodDto> cardListUp = dao.select(new TblStockprefoodDto(1,"",date,0,0));
		TblStockprefoodDto upRec = cardListUp.get(0);
		upRec.setPrefoodDate(java.sql.Date.valueOf("2030-06-10"));
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			cardListUp = dao.select(new TblStockprefoodDto(0,"",date,0,0));
			TblStockprefoodDaoTest.showAllData(cardListUp);
		} else {
			System.out.println("更新失敗！");
		}
		
	// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		List<TblStockprefoodDto> cardListDel = dao.select(new TblStockprefoodDto(9,"",date,0,0));
		TblStockprefoodDto delRec = cardListDel.get(0);
		if (dao.delete(delRec)) {
			System.out.println("削除成功！");
			cardListDel = dao.select(new TblStockprefoodDto(0, "",date,0,0));
			TblStockprefoodDaoTest.showAllData(cardListDel);
		} else {
			System.out.println("削除失敗！");
		}
		*/
	}
	
	
}

