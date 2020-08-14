package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbUtils.ConnectionUtils;
import entity.AppUser;

public class UserData {

	private static ResultSet rs;
	private static Connection conn;
	private static PreparedStatement pstmt = null;

	public static List<AppUser> getAll() {
		List<AppUser> data = new ArrayList<AppUser>();
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "select id, first_name, last_name, email, user_name, password from app_user";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			AppUser u = new AppUser();
			
			while (rs.next()) {
				data = new ArrayList<>();
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("first_name"));
				u.setLastName(rs.getString("last_name"));
				u.setUserName(rs.getString("user_name"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
				data.add(u);
			}
			System.out.println("Odradio transakciju");
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
		
		return data;
	}

}
