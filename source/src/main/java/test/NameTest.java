package test;

import java.util.List;

import dao.TblSafestampDao;
import dto.TblSafestampDto;

public class NameTest {

	    public static void main(String[] args) {
	        // 検証したい familyId をセット
	        String testFamilyId = "Satake09 "; // ← 実際のDBに存在するfamilyIdに合わせてね！

	        // DAOを使ってデータを取得
	        TblSafestampDao dao = new TblSafestampDao();
	        List<TblSafestampDto> list = dao.findWithNameByFamilyId(testFamilyId);

	        // 結果を出力して確認
	        for (TblSafestampDto dto : list) {
	            System.out.println("safeNumber: " + dto.getSafeNumber());
	            System.out.println("userNumber: " + dto.getUserNumber());
	            System.out.println("name: " + dto.getName());
	            System.out.println("status: " + dto.getStatus());
	            System.out.println("familyId: " + dto.getFamilyId());
	            System.out.println("-----------------------------");
	        }

	        if (list.isEmpty()) {
	            System.out.println("データが存在しません。");
	        }
	    }
	}


