package test;

import java.util.List;

import dao.TblLifehackfavoriteDao;
import dto.TblLifehackfavoriteDto;


public class TblLifehackfavoriteTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		//テストしたいDAOでインスタンスを生成
		TblLifehackfavoriteDao dao = new TblLifehackfavoriteDao();
		
		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<TblLifehackfavoriteDto> user = dao.select(new TblLifehackfavoriteDto(1, "", 1));
		TblRegistuserDAOTest.showAllData(user);


	}
	
	//テーブルを結合させたデータの取り方
	public class TblRegistuserDAOTest {
		public static void showAllData(List<TblLifehackfavoriteDto> userList) {
			for (TblLifehackfavoriteDto user : userList) {
				System.out.println("お気に入り番号：" + user.getLifehackfavoriteNumber());
				System.out.println("家族ID:" + user.getFamilyId());
				System.out.println("タイトル：" + user.getLifehack().getTitle());
				System.out.println("写真：" + user.getLifehack().getPhoto());
				System.out.println("文章：" + user.getLifehack().getTextline());
				System.out.println();
			}
			
		}
		
	}
}
