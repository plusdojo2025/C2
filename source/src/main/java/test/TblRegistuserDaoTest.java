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
		List<TblRegistuserDto> user = dao.select(new TblRegistuserDto(1, "", "", "", ""));
		TblRegistuserDaoTest.showAllData(user);
	
	
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		TblRegistuserDto insUser = new TblRegistuserDto(0, "satake1010@gmail.com", "passworddayo", "", "Satake09");
		if (dao.insert(insUser)) {
			System.out.println("登録成功！");
			List<TblRegistuserDto> userListIns = dao.select(new TblRegistuserDto(0, "", "", "", ""));
			TblRegistuserDaoTest.showAllData(userListIns);
		} else {
			System.out.println("登録失敗！");
		}
			
		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		List<TblRegistuserDto> userListUp = dao.select(new TblRegistuserDto(1, "","Wakusei03","",""));
		TblRegistuserDto upUser = userListUp.get(0);
		upUser.setPassword("Satakedayo09");
		if (dao.update(upUser)) {
			System.out.println("更新成功！");
			userListUp = dao.select(new TblRegistuserDto(0, "", "", "", ""));
			TblRegistuserDaoTest.showAllData(userListUp);
		} else {
			System.out.println("更新失敗！");
		}
	}
		
	
}
	
