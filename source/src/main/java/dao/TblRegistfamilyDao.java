package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblRegistfamilyDto;

public class TblRegistfamilyDao extends CustomTemplateDao<TblRegistfamilyDto> {

	@Override
	public List<TblRegistfamilyDto> select(TblRegistfamilyDto dto) {
		Connection conn = null;
		List<TblRegistfamilyDto> family = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_registfamily WHERE familyId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFamilyId());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblRegistfamilyDto a = new TblRegistfamilyDto(rs.getString("familyId")
				);				
				family.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			family = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return family;
	}

	@Override
	public boolean insert(TblRegistfamilyDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT INTO tbl_registfamily (familyId)
										VALUES(?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFamilyId());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
			// データベースを切断
			close(conn);
			}
			// 結果を返す
			return result;
}

	@Override
	public boolean update(TblRegistfamilyDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(TblRegistfamilyDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	
	public boolean exists(String familyId) { String sql = "SELECT 1 FROM tbl_registfamily WHERE familyId = ? LIMIT 1";

    try (Connection conn = conn();
         PreparedStatement pStmt = conn.prepareStatement(sql)) {

        pStmt.setString(1, familyId);

        try (ResultSet rs = pStmt.executeQuery()) {
            if (rs.next()) {
                // 1行でもあれば存在する
                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    // 見つからなかった or エラー時はfalseを返す
    return false;
		
	}
	
	
}
