package test;

import java.util.List;

//テストしたいDAOとDTOをインポート
import dao.TblCheckbagDao;
import dto.TblCheckbagDto;



public class TblCheckbagTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		//テストしたいDAOでインスタンスを生成
				TblCheckbagDao dao = new TblCheckbagDao();
				
				// select()のテスト1
				System.out.println("---------- select()のテスト1 ----------");
				List<TblCheckbagDto> user = dao.select(new TblCheckbagDto(2, false, "", 2,"" , 1));
				TblRegistuserDAOTest.showAllData(user);
			}
			
			
			public class TblRegistuserDAOTest {
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

	}

}
