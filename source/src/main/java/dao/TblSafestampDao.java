package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
					INSERT tbl_safestamp (status,familyId,userNumber)
										VALUES(?,?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getStatus());
			pStmt.setString(2, dto.getFamilyId());
			pStmt.setInt(3, dto.getUserNumber());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				res.next();
				dto.setUserNumber(res.getInt(1));
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
}
