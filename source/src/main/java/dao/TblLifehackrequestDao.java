package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.TblLifehackrequestDto;

public class TblLifehackrequestDao extends CustomTemplateDao<TblLifehackrequestDto>{
	
	@Override
	public List<TblLifehackrequestDto> select(TblLifehackrequestDto dto) {
		Connection conn = null;
		List<TblLifehackrequestDto> requests = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_lifehackrequest WHERE registNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getRegistNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblLifehackrequestDto request = new TblLifehackrequestDto(rs.getInt("registNumber"),
								rs.getString("title"), 
								rs.getString("photo"), 
								rs.getString("textline")
				);				
				requests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			requests = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return requests;
	}
	
	@Override
	public boolean insert(TblLifehackrequestDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT INTO tbl_lifehackrequest (title,photo,textline)
										VALUES(?,?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			pStmt.setString(1, dto.getTitle());
			pStmt.setString(2, dto.getPhoto());
			pStmt.setString(3, dto.getTextline());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				if(res.next()) {
				dto.setRegistNumber(res.getInt(1));
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
	public boolean update(TblLifehackrequestDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	@Override
	public boolean delete(TblLifehackrequestDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = "DELETE FROM tbl_lifehackrequest WHERE registNumber=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getRegistNumber());

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
