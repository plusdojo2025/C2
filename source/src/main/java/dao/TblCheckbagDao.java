package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String sql = "SELECT * FROM tbl_checkbag WHERE userNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getUserNumber());
			
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
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT INTO tbl_checkbag (bagCheck,bagName,bagStock,bagLink,userNumber)
										VALUES(?,?,?,?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			// SQL文を完成させる
			pStmt.setBoolean(1, dto.getBagCheck());
			pStmt.setString(2, dto.getBagName());
			pStmt.setInt(3, dto.getBagStock());
			pStmt.setString(4, dto.getBagLink());
			pStmt.setInt(5, dto.getUserNumber());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				if(res.next()) {
				dto.setBagNumber(res.getInt(1));
				result = true;
				}else {
					System.err.println("主キー生成不可。");		
				} 
			} 
		}
			catch (SQLException e) {
				e.printStackTrace();
			} finally {
			// データベースを切断
			close(conn);
			}
			// 結果を返す
			return result;
	}

	@Override
	public boolean update(TblCheckbagDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					UPDATE tbl_checkbag 
					SET 
						bagCheck = ?,
						bagName = ?,
						bagStock = ?,
						bagLink = ?,
						userNumber = ?
					WHERE bagNumber = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			pStmt.setBoolean(1, dto.getBagCheck());
			pStmt.setString(2, dto.getBagName());
			pStmt.setInt(3, dto.getBagStock());
			pStmt.setString(4, dto.getBagLink());
			pStmt.setInt(5, dto.getUserNumber());
			pStmt.setInt(6, dto.getBagNumber());
			
			
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
	public boolean delete(TblCheckbagDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	public boolean copyTemplateForUser(int userNumber) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    boolean result = false;

	    try {
	        conn = conn();  // DB接続

	        String sql = """
	            INSERT INTO tbl_checkbag (bagCheck, bagName, bagStock, bagLink, userNumber)
	            SELECT bagCheck, bagName, bagStock, bagLink, ?
	            FROM tbl_checkbagtemp
	        """;

	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, userNumber); // 全レコードにこのuserNumberを付加

	        int rows = pstmt.executeUpdate();
	        result = rows > 0; // コピーした行数が1行以上なら成功とみなす

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(conn);
	    }

	    return result;
	}
}
