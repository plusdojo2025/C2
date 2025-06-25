package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.IdPw;
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
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					INSERT INTO tbl_registuser (mail,password,name,familyId)
										VALUES(?,?,?,?)
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			pStmt.setString(1, dto.getMail());
			pStmt.setString(2, dto.getPassword());
			pStmt.setString(3, dto.getName());
			pStmt.setString(4, dto.getFamilyId());
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				ResultSet res = pStmt.getGeneratedKeys();
				if(res.next()) {
				dto.setUserNumber(res.getInt(1));
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
	public boolean update(TblRegistuserDto dto) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			// データベースに接続する
			conn = conn();

			// SQL文を準備する
			String sql = """
					UPDATE tbl_registuser 
					SET 
						mail = ?,
						password = ?,
						name = ?,
						familyId = ?
					WHERE userNumber = ?
					""";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, dto.getMail());
			pStmt.setString(2, dto.getPassword());
			pStmt.setString(3, dto.getName());
			pStmt.setString(4, dto.getFamilyId());
			pStmt.setInt(5, dto.getUserNumber());
			
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
	public boolean delete(TblRegistuserDto dto) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				// データベースに接続する
				conn = conn();

				// SQL文を準備する
				String sql = "DELETE FROM tbl_registuser WHERE userNumber=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, dto.getUserNumber());

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
	public boolean insert (IdPw dto) {
		Connection conn = null;
		boolean loginResult = false;

		try {
		conn = conn();

		// SELECT文を準備する
			String sql = "SELECT count(*) FROM tbl_registuser WHERE mail=? AND password=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dto.getMail());
			pStmt.setString(2, dto.getPassword());
	
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}  catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			close(conn);
		}

		// 結果を返す
		return loginResult;
	}
	
	//セッション関係追記ここから
	public TblRegistuserDto selectByMail(String mail) {
		Connection conn = null;
		TblRegistuserDto user = null;

		try {
			conn = conn();
			String sql = "SELECT * FROM tbl_registuser WHERE mail = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mail);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				user = new TblRegistuserDto(
					rs.getInt("userNumber"),
					rs.getString("mail"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("familyId")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return user;
	}
	//セッション関係追記ここまで

	public boolean existsMail(String mail) { String sql = "SELECT 1 FROM tbl_registuser WHERE mail = ? LIMIT 1";

    try (Connection conn = conn();
         PreparedStatement pStmt = conn.prepareStatement(sql)) {

        pStmt.setString(1, mail);

        try (ResultSet rs = pStmt.executeQuery()) {
            if (rs.next()) {
                // 1行でもあれば存在する
                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    // 見つからなかった or エラー時はfalseを返す
    return false;
		
	}
	
	public boolean existsFamilyId(String FamilyId) { String sql = "SELECT 1 FROM tbl_registuser WHERE familyId = ? LIMIT 1";

    try (Connection conn = conn();
         PreparedStatement pStmt = conn.prepareStatement(sql)) {

        pStmt.setString(1, FamilyId);

        try (ResultSet rs = pStmt.executeQuery()) {
            if (rs.next()) {
                // 1行でもあれば存在する
                return true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    // 見つからなかった or エラー時はfalseを返す
    return false;
		
	}
}
