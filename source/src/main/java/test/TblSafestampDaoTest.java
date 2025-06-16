package test;

import java.util.List;

import dao.TblSafestampDao;
import dto.TblSafestampDto;

public class TblSafestampDaoTest {

	static void showAllData(List<TblSafestampDto> userList) {
		for (TblSafestampDto user : userList) {
			System.out.println("安否確認番号：" + user.getSafeNumber());
			System.out.println("安否状況：" + user.getStatus());
			System.out.println("家族ID：" + user.getFamilyId());
			System.out.println("ユーザー番号：" + user.getUserNumber());
			System.out.println();
		}
	}
		
		public static void main(String[] args) {
			//テストしたいDAOでインスタンスを生成
			TblSafestampDao dao = new TblSafestampDao();
		
			// select()のテスト1
			System.out.println("---------- select()のテスト1 ----------");
			List<TblSafestampDto> user = dao.select(new TblSafestampDto(1, "", "", 0));
			TblSafestampDaoTest.showAllData(user);
			
			// insert()のテスト
			System.out.println("---------- insert()のテスト ----------");
			TblSafestampDto insUser = new TblSafestampDto(2, "SOS", "Satake09", 3);
			if (dao.insert(insUser)) {
				System.out.println("登録成功！");
				List<TblSafestampDto> userListIns = dao.select(new TblSafestampDto(0, "", "", 0));
				TblSafestampDaoTest.showAllData(userListIns);
			} else {
				System.out.println("登録失敗！");
			}
			
			// update()のテスト
			System.out.println("---------- update()のテスト1 ----------");
			List<TblSafestampDto> userListUp = dao.select(new TblSafestampDto(2, "","", 0));
			TblSafestampDto upUser = userListUp.get(0);
			upUser.setStatus("無事です");
			if (dao.update(upUser)) {
				System.out.println("更新成功！");
				userListUp = dao.select(new TblSafestampDto(0, "", "", 0));
				TblSafestampDaoTest.showAllData(userListUp);
			} else {
				System.out.println("更新失敗！");
			}
			
			//delete()のテスト
			System.out.println("---------- delete()のテスト ----------");
			List<TblSafestampDto> safestampDel = dao.select(new TblSafestampDto(4,"","",0));
			TblSafestampDto delRec = safestampDel.get(0);
			if (dao.delete(delRec)) {
				System.out.println("削除成功！");
				safestampDel = dao.select(new TblSafestampDto(0,"", "", 0));
				TblSafestampDaoTest.showAllData(safestampDel);
			} else {
				System.out.println("削除失敗！");
			}
		}
}
