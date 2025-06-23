package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String sql = "SELECT * FROM tbl_stockprefood WHERE userNumber = ? ORDER BY prefoodDate ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getUserNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblStockprefoodDto b = new TblStockprefoodDto(
						rs.getInt("prefoodNumber"),
	                    rs.getString("prefoodName"),
	                    rs.getDate("prefoodDate"),
	                    rs.getInt("prefoodQuantity"),
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
					INSERT INTO tbl_stockprefood (prefoodName,prefoodDate,prefoodQuantity,userNumber)
										VALUES(?,?,?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			pStmt.setString(1, dto.getPrefoodName());
			pStmt.setDate(2, dto.getPrefoodDate());
			pStmt.setInt(3, dto.getPrefoodQuantity());
			pStmt.setInt(4, dto.getUserNumber());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				if(res.next()) {
				dto.setPrefoodNumber(res.getInt(1));
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
	public boolean update(TblStockprefoodDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					UPDATE tbl_stockprefood
					SET 
						prefoodName = ?,
						prefoodDate = ?,
						prefoodQuantity = ?
					WHERE prefoodNumber = ? AND userNumber = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getPrefoodName());
			pStmt.setDate(2, dto.getPrefoodDate());
			pStmt.setInt(3, dto.getPrefoodQuantity());
			pStmt.setInt(4, dto.getPrefoodNumber());
			pStmt.setInt(5, dto.getUserNumber());
			
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
	public boolean delete(TblStockprefoodDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = "DELETE FROM tbl_stockprefood WHERE prefoodNumber=? AND userNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getPrefoodNumber());
			pStmt.setInt(2, dto.getUserNumber());

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

	//登録保存食データを全件表示させるためのselectAll()文を追加
	public List<TblStockprefoodDto> selectAll() {
		Connection conn = null;
		List<TblStockprefoodDto> prefood = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_stockprefood ORDER BY prefoodDate ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblStockprefoodDto b = new TblStockprefoodDto(rs.getInt("prefoodNumber"),
								rs.getString("prefoodName"),
								rs.getDate("prefoodDate"),
								rs.getInt("prefoodQuantity"),
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
	
	public List<TblStockprefoodDto> selectExpiringInDays(int daysAhead, int userNumber) {
	    Connection conn = null;
	    List<TblStockprefoodDto> result = new ArrayList<>();

	    try {
	        conn = conn(); 
	        String sql = """
	            SELECT * FROM tbl_stockprefood
	            WHERE prefoodDate = CURDATE() + INTERVAL ? DAY
	              AND userNumber = ?
	            ORDER BY prefoodDate ASC
	        """;

	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, daysAhead);
	        stmt.setInt(2, userNumber);

	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            TblStockprefoodDto dto = new TblStockprefoodDto(
	                rs.getInt("prefoodNumber"),
	                rs.getString("prefoodName"),
	                rs.getDate("prefoodDate"),
	                rs.getInt("prefoodQuantity"),
	                rs.getInt("userNumber")
	            );
	            result.add(dto);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn);
	    }

	    return result;
	}
	
	public List<Integer> getAllUserNumbers() {
	    Connection conn = null;
	    List<Integer> userNumbers = new ArrayList<>();
	    try {
	        conn = conn();
	        String sql = "SELECT DISTINCT userNumber FROM tbl_stockprefood";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            userNumbers.add(rs.getInt("userNumber"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn);
	    }
	    return userNumbers;
	}



}

