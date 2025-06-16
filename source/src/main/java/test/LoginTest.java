package test;

import dao.TblRegistuserDao;
import dto.IdPw;

public class LoginTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testLoginOK(); //ユーザーが見つかる場合のテスト
		testLoginNG(); //ユーザーが見つからない場合のテスト
	}
	
	//ユーザーが見つかる場合のテスト
	public static void testLoginOK() {
		//テストしたいDAOを指定
		TblRegistuserDao dao = new TblRegistuserDao();
		if (dao.insert(new IdPw("Hiromu8989@gmail.com", "Lucy23"))) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}
	
	//ユーザーが見つからない場合のテスト
		public static void testLoginNG() {
			//テストしたいDAOを指定
			TblRegistuserDao dao = new TblRegistuserDao();
			if (dao.insert(new IdPw("id", "pass"))) {
				System.out.println("testIsLoginOK1：テストが成功しました");
			} else {
				System.out.println("testIsLoginOK1：テストが失敗しました");
			}
		}

}
