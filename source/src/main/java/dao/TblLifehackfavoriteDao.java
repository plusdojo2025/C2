package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblLifehackfavoriteDto;

public class TblLifehackfavoriteDao extends CustomTemplateDao<TblLifehackfavoriteDto> {
	
	@Override
	public List<TblLifehackfavoriteDto> select(TblLifehackfavoriteDto dto) {
		Connection conn = null;
		List<TblLifehackfavoriteDto> favorite = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_lifehackfavorite WHERE familyId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getFamilyId());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblLifehackfavoriteDto f = new TblLifehackfavoriteDto(rs.getString("familyId"), 
								rs.getInt("lifehackNumber")
				);				
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
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(TblLifehackfavoriteDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(TblLifehackfavoriteDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
