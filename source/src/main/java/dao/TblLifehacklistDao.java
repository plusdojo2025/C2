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

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_lifehacklist WHERE title LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, "%" + dto.getTitle() + "%");
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblLifehacklistDto e = new TblLifehacklistDto(rs.getInt("lifehackNumber"), 
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
			// データベースを切断
			close(conn);
		}

		// 結果を返す
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

