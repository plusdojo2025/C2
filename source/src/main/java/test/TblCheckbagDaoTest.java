package test;

import java.util.List;

//テストしたいDAOとDTOをインポート
import dao.TblCheckbagDao;
import dto.TblCheckbagDto;


public class TblCheckbagDaoTest {
	public static void showAllData(List<TblCheckbagDto> userList) {
		for (TblCheckbagDto user : userList) {
			System.out.println("番号：" + user.getBagNumber());
			System.out.println("レ点：" + user.getBagCheck());
			System.out.println("品目名：" + user.getBagName());
			System.out.println("個数：" + user.getBagStock());
			System.out.println("リンク：" + user.getBagLink());
			System.out.println("ユーザーID：" + user.getUserNumber());
			System.out.println();
		}
	}
		
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		//テストしたいDAOでインスタンスを生成
		TblCheckbagDao dao = new TblCheckbagDao();
			
		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<TblCheckbagDto> user = dao.select(new TblCheckbagDto(2, false, "", 0,"" , 0));
		TblCheckbagDaoTest.showAllData(user);
		
	
		//insert()のテスト1
		System.out.println("---------- insert()のテスト ----------");
			TblCheckbagDto insUser = new TblCheckbagDto(0, false, "のど飴", 2, "購入リンク", 1);
			if (dao.insert(insUser)) {
				System.out.println("登録成功！");
				List<TblCheckbagDto> userListIns = dao.select(new TblCheckbagDto(0, false, "", 0, "", 0));
				TblCheckbagDaoTest.showAllData(userListIns);
			} else {
				System.out.println("登録失敗！");
			}
			
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
			List<TblCheckbagDto> userListUp = dao.select(new TblCheckbagDto(2, false, "",0,"",0));
			TblCheckbagDto upUser = userListUp.get(0);
			upUser.setBagName("ウェットティッシュ");
			if (dao.update(upUser)) {
				System.out.println("更新成功！");
				userListUp = dao.select(new TblCheckbagDto(0, false, "", 0, "",0));
				TblCheckbagDaoTest.showAllData(userListUp);
			} else {
				System.out.println("更新失敗！");
			}
	}
}
	
