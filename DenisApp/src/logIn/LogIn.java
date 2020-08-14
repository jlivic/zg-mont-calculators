package logIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtils.ConnectionUtils;
import entity.AppUser;

public class LogIn {

	private static ResultSet rs;
	private static Connection conn;
	private static PreparedStatement pstmt = null;

	public static boolean checkIfUserExist(String userName, String password) {
		boolean isExists = false;
		try {
			conn = ConnectionUtils.getConnection();

			String sql = "select id, first_name, last_name, user_name, email from APP_USER where user_name = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();

			AppUser u = new AppUser();
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setUserName(rs.getString("user_name"));
				u.setEmail(rs.getString("email"));
				isExists = true;
			}

			rs.close();

		} catch (

		SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se2) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return isExists;
	}
}
