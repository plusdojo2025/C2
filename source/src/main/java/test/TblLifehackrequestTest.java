package test;

import dao.TblLifehackrequestDao;
import dto.TblLifehackrequestDto;

public class TblLifehackrequestTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//insert()のテスト1
		System.out.println("---------- insert()のテスト ----------");
		    TblLifehackrequestDao dao = new TblLifehackrequestDao();
		    TblLifehackrequestDto dto = new TblLifehackrequestDto(0, "タイトル", "写真", "説明文");
			if (dao.insert(dto)) {
				System.out.println("登録成功！");
			} else {
				System.out.println("登録失敗！");
			}

	}
}
