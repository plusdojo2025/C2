package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblLifehackfavoriteDto;
import dto.TblLifehacklistDto;

public class TblLifehackfavoriteDao extends CustomTemplateDao<TblLifehackfavoriteDto> {
	
	@Override
	public List<TblLifehackfavoriteDto> select(TblLifehackfavoriteDto dto) {
		Connection conn = null;
		List<TblLifehackfavoriteDto> favorite = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT title, photo, textline, lifehackfavoriteNumber, familyId FROM tbl_lifehacklist "
					+ "JOIN tbl_lifehackfavorite ON tbl_lifehacklist.lifehackNumber = tbl_lifehackfavorite.lifehackNumber"
					+ " WHERE lifehackfavoriteNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getLifehackfavoriteNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				//リストのDTOを作成
				TblLifehacklistDto list = new TblLifehacklistDto();
				list.setTitle(rs.getString("title"));
				list.setPhoto(rs.getString("photo"));
				list.setTextline(rs.getString("textline"));
				
				//favoriteDTOを作成
				TblLifehackfavoriteDto f = new TblLifehackfavoriteDto();
				f.setLifehackfavoriteNumber(rs.getInt("lifehackfavoriteNumber"));
				f.setFamilyId(rs.getString("familyId"));
				
				//listに入っているtitleなどをｆに追加
				f.setLifehack(list);
				
				favorite.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			favorite= null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return favorite;
	}

	@Override
	public boolean insert(TblLifehackfavoriteDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT tbl_registuser (familyId,lifehackNumber)
										VALUES(?,0)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFamilyId());
			//pStmt.setInt(2, dto.getLifehackNumber());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				res.next();
				dto.setLifehackfavoriteNumber(res.getInt(1));
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
	public boolean update(TblLifehackfavoriteDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					UPDATE tbl_lifehackfavorite
					SET 
						familyId = ?,
						lifehackNumber = ?
					WHERE lifehackfavoriteNumber = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFamilyId());
			//pStmt.setInt(2, dto.getLifehackNumber());
			
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
	public boolean delete(TblLifehackfavoriteDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = "DELETE FROM Bc WHERE lifehackfavoriteNumber=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getLifehackfavoriteNumber());

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
