package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblStockprefoodDto;

public class TblStockprefoodDao extends CustomTemplateDao<TblStockprefoodDto> {

	@Override
	public List<TblStockprefoodDto> select(TblStockprefoodDto dto) {
		Connection conn = null;
		List<TblStockprefoodDto> prefood = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_stockprefood WHERE prefoodNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getPrefoodNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblStockprefoodDto b = new TblStockprefoodDto(rs.getInt("prefoodNumber"),
								rs.getString("prefoodName"),
								rs.getDate("prefoodDate"),
								rs.getInt("userNumber")
				);				
				prefood.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			prefood = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return prefood;
	}

	@Override
	public boolean insert(TblStockprefoodDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT tbl_stockprefood (prefoodName,prefoodDate,userNumber)
										VALUES(?,?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getPrefoodName());
			pStmt.setDate(2, dto.getPrefoodDate());
			pStmt.setInt(3, dto.getUserNumber());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				res.next();
				dto.setPrefoodNumber(res.getInt(1));
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
	public boolean update(TblStockprefoodDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(TblStockprefoodDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = "DELETE FROM tbl_stockprefood WHERE prefoodNumber=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getPrefoodNumber());

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

