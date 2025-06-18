package test;

import java.util.List;

import dao.TblLifehacklistDao;
import dto.TblLifehacklistDto;

public class TblLifehacklistTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//テストしたいDAOでインスタンスを生成
		TblLifehacklistDao dao = new TblLifehacklistDao();
			
		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<dto.TblLifehacklistDto> user = dao.select(new dto.TblLifehacklistDto(0, "", "", "" ));
		TblLifehacklistTest.showAllData(user);
		
		}

	public static void showAllData(List<TblLifehacklistDto> userList) {
		for (TblLifehacklistDto user : userList) {
			System.out.println("番号：" + user.getLifehackNumber());
			System.out.println("タイトル：" + user.getTitle());
			System.out.println("写真：" + user.getPhoto());
			System.out.println("説明文：" + user.getTextline());
			
			System.out.println();
		}
	
	}
}
