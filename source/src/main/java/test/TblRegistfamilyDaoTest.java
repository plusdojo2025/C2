package test;

import java.util.List;

import dao.TblRegistfamilyDao;
import dto.TblRegistfamilyDto;

public class TblRegistfamilyDaoTest {
	
	public static void showAllData(List<TblRegistfamilyDto> familyList) {
		for (TblRegistfamilyDto family : familyList) {
			System.out.println("番号：" + family.getFamilyId());
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TblRegistfamilyDao dao = new TblRegistfamilyDao();
		
		// select()のテスト1
		System.out.println("---------- select()のテスト1 ----------");
		List<TblRegistfamilyDto> cardListSel1 = dao.select(new TblRegistfamilyDto("Satake09"));
		TblRegistfamilyDaoTest.showAllData(cardListSel1);
		
		
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		TblRegistfamilyDto insFamily = new TblRegistfamilyDto("Murakami03");
		if (dao.insert(insFamily)) {
			System.out.println("登録成功！");
			List<TblRegistfamilyDto> cardListIns = dao.select(new TblRegistfamilyDto(""));
			TblRegistfamilyDaoTest.showAllData(cardListIns);
		} else {
			System.out.println("登録失敗！");
		}
	}

}
