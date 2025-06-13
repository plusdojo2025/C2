package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TblCheckbagtempDto;

public class TblCheckbagtempDao extends CustomTemplateDao<TblCheckbagtempDto> {
	
	@Override
	public List<TblCheckbagtempDto> select(TblCheckbagtempDto dto) {
		Connection conn = null;
		List<TblCheckbagtempDto> template = new ArrayList<>();

		try {
		conn = conn();

			// SQL文を準備する
			String sql = "SELECT * FROM tbl_checkbagtemp WHERE bagNumber = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, dto.getBagNumber());
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TblCheckbagtempDto c = new TblCheckbagtempDto(rs.getInt("bagNumber"), 
								rs.getBoolean("bagCheck"), 
								rs.getString("bagName"), 
								rs.getInt("bagStock"), 
								rs.getString("bagLink")
				);				
				template.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			template = null;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return template;
	}

	@Override
	public boolean insert(TblCheckbagtempDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(TblCheckbagtempDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean delete(TblCheckbagtempDto dto) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
