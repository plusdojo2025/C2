package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblLifehacklistDto;

public class TblLifehacklistDao extends CustomTemplateDao<TblLifehacklistDto> {

	@Override
	public List<TblLifehacklistDto> select(TblLifehacklistDto dto) {
	    Connection conn = null;
	    List<TblLifehacklistDto> lifehack = new ArrayList<>();

	    try {
	        conn = conn();

	        PreparedStatement pStmt;
	        String sql;

	        if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
	            sql = "SELECT * FROM tbl_lifehacklist ORDER BY lifehackNumber ASC";
	            pStmt = conn.prepareStatement(sql);
	        } else {
	            sql = "SELECT * FROM tbl_lifehacklist WHERE title LIKE ? ORDER BY lifehackNumber ASC";
	            pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, "%" + dto.getTitle() + "%");
	        }

	        ResultSet rs = pStmt.executeQuery();

	        while (rs.next()) {
	            TblLifehacklistDto e = new TblLifehacklistDto(
	                rs.getInt("lifehackNumber"),
	                rs.getString("title"),
	                rs.getString("photo"),
	                rs.getString("textline")
	            );
	            lifehack.add(e);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        lifehack = null;
	    } finally {
	        close(conn);
	    }

	    return lifehack;
	}


	@Override
	public boolean insert(TblLifehacklistDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(TblLifehacklistDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
//List<Integer>をbooleanに変更した　間違ってたら直して！（玉川）
	@Override
	public boolean delete(TblLifehacklistDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;

	}	
	
	
}

