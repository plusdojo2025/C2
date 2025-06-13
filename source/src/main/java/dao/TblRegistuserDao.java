package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblRegistuserDto;

public class TblRegistuserDao extends CustomTemplateDao<TblRegistuserDto> {

	@Override
	public List<TblRegistuserDto> select(TblRegistuserDto dto) {
		Connection conn = null;
		List<TblRegistuserDto> users = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_registuser WHERE userNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getUserNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblRegistuserDto user = new TblRegistuserDto(rs.getInt("userNumber"), 
								rs.getString("mail"), 
								rs.getString("password"), 
								rs.getString("name"), 
								rs.getString("familyId")
				);				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			users = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return users;
	}

	@Override
	public boolean insert(TblRegistuserDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(TblRegistuserDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(TblRegistuserDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
