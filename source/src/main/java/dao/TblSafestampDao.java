package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.TblSafestampDto;

public class TblSafestampDao extends CustomTemplateDao<TblSafestampDto> {

	@Override
	public List<TblSafestampDto> select(TblSafestampDto dto) {
		Connection conn = null;
		List<TblSafestampDto> safestamp = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_safestamp WHERE safeNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getSafeNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblSafestampDto g = new TblSafestampDto(rs.getInt("safeNumber"), 
								rs.getString("status"),
								rs.getString("familyId"), 
								rs.getInt("userNumber")
				);				
				safestamp.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			safestamp = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return safestamp;
	}

	@Override
	public boolean insert(TblSafestampDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT INTO tbl_safestamp (status,familyId,userNumber)
										VALUES(?,?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			pStmt.setString(1, dto.getStatus());
			pStmt.setString(2, dto.getFamilyId());
			pStmt.setInt(3, dto.getUserNumber());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				if(res.next()) {
				dto.setSafeNumber(res.getInt(1));
				result = true;
				}else {
					System.err.println("主キー生成不可。");		
				} 
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
	public boolean update(TblSafestampDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					UPDATE tbl_safestamp
					SET 
						status = ?,
						familyId = ?,
						userNumber = ?
					WHERE safeNumber = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getStatus());
			pStmt.setString(2, dto.getFamilyId());
			pStmt.setInt(3, dto.getUserNumber());
			pStmt.setInt(4, dto.getSafeNumber());
			
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
	public boolean delete(TblSafestampDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = "DELETE FROM tbl_safestamp WHERE safeNumber=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getSafeNumber());

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
	
	public List<TblSafestampDto> findWithNameByFamilyId(String familyId) {
	    Connection conn = null;
	    List<TblSafestampDto> list = new ArrayList<>();

	    try {
	        conn = conn(); // ← DBに接続

	        String sql = """
	            SELECT ss.safeNumber, ss.status, ss.familyId, ss.userNumber, ru.name
	            FROM tbl_safestamp ss
	            JOIN tbl_registuser ru ON ss.userNumber = ru.userNumber
	            WHERE ss.familyId = ?
	        """;

	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, familyId); // ← プレースホルダに値をセット

	        ResultSet rs = pStmt.executeQuery();

	        while (rs.next()) {
	            TblSafestampDto dto = new TblSafestampDto();
	            dto.setSafeNumber(rs.getInt("safeNumber"));
	            dto.setStatus(rs.getString("status"));
	            dto.setFamilyId(rs.getString("familyId"));
	            dto.setUserNumber(rs.getInt("userNumber"));
	            dto.setName(rs.getString("name")); // ← これがJOINで得たユーザー名！

	            list.add(dto);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn); // ← コネクションを閉じる
	    }

	    return list;
	}

}
