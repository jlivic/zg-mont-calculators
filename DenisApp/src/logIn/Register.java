package logIn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbUtils.ConnectionUtils;
import entity.AppUser;

public class Register {
	
	private static Connection conn;
	
	public static void registerUser(AppUser user) {
		
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "insert into app_user values(seq_app_user.nextval, ?, ?, ?, ?, ?, 1)";
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, user.getUserName());
			p.setString(2, user.getPassword());
			p.setString(3, user.getEmail());
			p.setString(4, user.getFirstName());
			p.setString(5, user.getLastName());
			
			p.executeUpdate();
			
			if(p != null)
				p.close();
		
		}catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
}
