package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblCheckbagDto;

public class TblCheckbagDao extends CustomTemplateDao<TblCheckbagDto> {

	@Override
	public List<TblCheckbagDto> select(TblCheckbagDto dto) {
		Connection conn = null;
		List<TblCheckbagDto> checkbag = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_checkbag WHERE bagNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getBagNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblCheckbagDto d = new TblCheckbagDto(rs.getInt("bagNumber"), 
								rs.getBoolean("bagCheck"), 
								rs.getString("bagName"), 
								rs.getInt("bagStock"), 
								rs.getString("bagLink"),
								rs.getInt("userNumber")
				);				
				checkbag.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			checkbag = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return checkbag;
	}

	@Override
	public boolean insert(TblCheckbagDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(TblCheckbagDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(TblCheckbagDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
