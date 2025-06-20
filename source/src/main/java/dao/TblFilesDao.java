package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.TblFilesDto;

public class TblFilesDao extends CustomTemplateDao<TblFilesDto> {
	
	@Override
	public List<TblFilesDto> select(TblFilesDto dto) {
		Connection conn = null;
		List<TblFilesDto> files = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM files WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getId());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblFilesDto file = new TblFilesDto(rs.getInt("id"), 
								rs.getString("filename"), 
								rs.getBytes("filedata")
				);				
				files.add(file);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			files = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return files;
	}
	
	@Override
	public boolean insert(TblFilesDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT INTO files (filename, filedata)
										VALUES(?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFilename());
			pStmt.setBytes(2, dto.getFiledata());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				if(res.next()) {
				dto.setId(res.getInt(1));
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
	public boolean update(TblFilesDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					UPDATE files 
					SET 
						filename = ?,
						filedata = ?
					WHERE id = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFilename());
			pStmt.setBytes(2, dto.getFiledata());
			pStmt.setInt(3, dto.getId());
			
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
	public boolean delete(TblFilesDto dto) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				// データベースに接続する
				conn = conn();

				// SQL文を準備する
				String sql = "DELETE FROM files WHERE id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, dto.getId());

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
