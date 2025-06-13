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
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(TblSafestampDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(TblSafestampDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
