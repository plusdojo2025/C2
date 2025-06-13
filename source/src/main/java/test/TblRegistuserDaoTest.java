package test;


import java.util.List;

//テストしたいDAOとDTOをインポート
import dao.TblRegistuserDao;
import dto.TblRegistuserDto;


public class TblRegistuserDaoTest {
	public static void main(String[] args) {
		//テストしたいDAOでインスタンスを生成
		TblRegistuserDao dao = new TblRegistuserDao();
		
		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<TblRegistuserDto> user = dao.select(new TblRegistuserDto(2, "", "", "", ""));
		TblRegistuserDAOTest.showAllData(user);
	}
	
	
	public class TblRegistuserDAOTest {
		public static void showAllData(List<TblRegistuserDto> userList) {
			for (TblRegistuserDto user : userList) {
				System.out.println("番号：" + user.getUserNumber());
				System.out.println("メールアドレス：" + user.getMail());
				System.out.println("パスワード：" + user.getPassword());
				System.out.println("氏名：" + user.getName());
				System.out.println("家族ID：" + user.getFamilyId());
				System.out.println();
			}
		}

	
	}
}
