package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
					INSERT INTO tbl_lifehackfavorite (familyId,lifehackNumber)
										VALUES(?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFamilyId());
			pStmt.setInt(2, dto.getLifehackNumber());
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				if(res.next()) {
				dto.setLifehackfavoriteNumber(res.getInt(1));
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
			pStmt.setInt(2, dto.getLifehackNumber());
			pStmt.setInt(3, dto.getLifehackfavoriteNumber());
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
			String sql = "DELETE FROM tbl_lifehackfavorite WHERE lifehackfavoriteNumber=?";
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
	
	//一覧表示取得機能追記ここから
	public List<TblLifehackfavoriteDto> selectByFamilyId(TblLifehackfavoriteDto dto) {
	    Connection conn = null;
	    List<TblLifehackfavoriteDto> favorite = new ArrayList<>();

	    try {
	        conn = conn();

	        String sql = """
	            SELECT tbl_lifehacklist.lifehackNumber, title, photo, textline, 
	                   lifehackfavoriteNumber, familyId
	            FROM tbl_lifehacklist
	            JOIN tbl_lifehackfavorite 
	            ON tbl_lifehacklist.lifehackNumber = tbl_lifehackfavorite.lifehackNumber
	            WHERE familyId = ?
	        """;

	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, dto.getFamilyId());

	        ResultSet rs = pStmt.executeQuery();

	        while (rs.next()) {
	        	System.out.println("---- 取得結果 ----");
	        	System.out.println("title: " + rs.getString("title"));
	        	System.out.println("photo: " + rs.getString("photo"));
	        	System.out.println("textline: " + rs.getString("textline"));
	        	System.out.println("lifehackNumber: " + rs.getInt("lifehackNumber"));
	        	System.out.println("familyId: " + rs.getString("familyId"));
	        	System.out.println("-----------------");

	            TblLifehacklistDto list = new TblLifehacklistDto();
	            list.setLifehackNumber(rs.getInt("lifehackNumber")); // ★追加
	            list.setTitle(rs.getString("title"));
	            list.setPhoto(rs.getString("photo"));
	            list.setTextline(rs.getString("textline"));

	            TblLifehackfavoriteDto f = new TblLifehackfavoriteDto();
	            f.setLifehackfavoriteNumber(rs.getInt("lifehackfavoriteNumber"));
	            f.setFamilyId(rs.getString("familyId"));
	            f.setLifehackNumber(rs.getInt("lifehackNumber")); // ★追加
	            f.setLifehack(list);

	            favorite.add(f);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        favorite = null;
	    } finally {
	        close(conn);
	    }

	    return favorite;
	}

//玉川追加↓
	public List<Integer> selectLifehackNumbersByFamilyId(String familyId){
        List<Integer> ids = new ArrayList<>();
        Connection conn = null;
        try {
            conn = conn();
            String sql = "SELECT lifehackNumber FROM tbl_lifehackfavorite WHERE familyId=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, familyId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("lifehackNumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return ids;
}
	/*
	public List<TblLifehackfavoriteDto> selectByFamilyId(TblLifehackfavoriteDto dto) {
	    Connection conn = null;
	    List<TblLifehackfavoriteDto> favorite = new ArrayList<>();

	    try {
	        conn = conn();

	        String sql = """
	            SELECT title, photo, textline, lifehackfavoriteNumber, familyId
	            FROM tbl_lifehacklist
	            JOIN tbl_lifehackfavorite 
	            ON tbl_lifehacklist.lifehackNumber = tbl_lifehackfavorite.lifehackNumber
	            WHERE familyId = ?
	        """;

	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, dto.getFamilyId());

	        ResultSet rs = pStmt.executeQuery();

	        while (rs.next()) {
	            TblLifehacklistDto list = new TblLifehacklistDto();
	            list.setTitle(rs.getString("title"));
	            list.setPhoto(rs.getString("photo"));
	            list.setTextline(rs.getString("textline"));

	            TblLifehackfavoriteDto f = new TblLifehackfavoriteDto();
	            f.setLifehackfavoriteNumber(rs.getInt("lifehackfavoriteNumber"));
	            f.setFamilyId(rs.getString("familyId"));
	            f.setLifehack(list);

	            favorite.add(f);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        favorite = null;
	    } finally {
	        close(conn);
	    }

	    return favorite;
	}
	*/
	//一覧表示取得機能追記ここまで
}
