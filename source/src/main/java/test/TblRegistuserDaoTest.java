package test;


import java.util.List;

//テストしたいDAOとDTOをインポート
import dao.TblRegistuserDao;
import dto.TblRegistuserDto;


public class TblRegistuserDaoTest {
		
		static void showAllData(List<TblRegistuserDto> userList) {
			for (TblRegistuserDto user : userList) {
				System.out.println("番号：" + user.getUserNumber());
				System.out.println("メールアドレス：" + user.getMail());
				System.out.println("パスワード：" + user.getPassword());
				System.out.println("氏名：" + user.getName());
				System.out.println("家族ID：" + user.getFamilyId());
				System.out.println();
			}
		}
		
	public static void main(String[] args) {
		//テストしたいDAOでインスタンスを生成
		TblRegistuserDao dao = new TblRegistuserDao();
		
		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<TblRegistuserDto> user = dao.select(new TblRegistuserDto(2, "", "", "", ""));
		TblRegistuserDaoTest.showAllData(user);
	
	
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		TblRegistuserDto insRec = new TblRegistuserDto(0, "newemail`gmail.com", "passworddayo", "", "Satake09");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<TblRegistuserDto> cardListIns = dao.select(new TblRegistuserDto(0, "", "", "", ""));
			TblRegistuserDaoTest.showAllData(cardListIns);
		} else {
			System.out.println("登録失敗！");
			
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		List<TblRegistuserDto> cardListUp = dao.select(new TblRegistuserDto(0, "","Wakusei03","",""));
		TblRegistuserDto upRec = cardListUp.get(0);
		upRec.setPassword("Satakedayo09");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			cardListUp = dao.select(new TblRegistuserDto(0, "", "", "", ""));
			TblRegistuserDaoTest.showAllData(cardListUp);
		} else {
			System.out.println("更新失敗！");
		}
	}
		
	
	}
	
}
