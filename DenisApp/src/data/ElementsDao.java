package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbUtils.ConnectionUtils;
import entity.AppUser;
import entity.Elements;

public class ElementsDao {

	private static ResultSet rs;
	private static Connection conn;
	private static PreparedStatement pstmt = null;

	public static Elements findByName(String elementName) {
		Elements e = new Elements();
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "select id, material_name, c, mn, cr, mo, v, ni, cu, si, b from elements where material_name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, elementName);
			rs = pstmt.executeQuery();

			
			
			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setMaterialName(rs.getString("material_name"));
				e.setC(rs.getDouble("c"));
				e.setMn(rs.getDouble("mn"));
				e.setCr(rs.getDouble("cr"));
				e.setMo(rs.getDouble("mo"));
				e.setV(rs.getDouble("v"));
				e.setNi(rs.getDouble("ni"));
				e.setCu(rs.getDouble("cu"));
				e.setSi(rs.getDouble("si"));
				e.setB(rs.getDouble("b"));
			}
			
			rs.close();

		} catch (

		SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
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
		
		return e;
	}
	
	public static List<String> findAll() {
		List<String> data = new ArrayList<String>();
		try {
			conn = ConnectionUtils.getConnection();
			String sql = "select material_name from elements";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			
			
			while (rs.next()) {
				String materialName = rs.getString("material_name");
				data.add(materialName);
			}
			
			rs.close();

		} catch (

		SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
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
	
	public static String calculate1011_2_CE(Elements e) {
		Double result = e.getC() + (e.getMn()/6) + ((e.getCr() + e.getMo())/5) + ((e.getNi() + e.getCu())/15);
		return result.toString();
	}
	
	public static String calculate1011_2_cet(Elements e) {
		Double result = e.getC() + ((e.getMn() + e.getMo())/10) + ((e.getCr() + e.getCu())/20) + (e.getNi()/40);
		return result.toString();
	}
	
	public static String calculateAws(Elements e) {
		Double result = e.getC() + (e.getSi()/30) + ((e.getMn() + e.getCr() + e.getCu())/20) + (e.getNi()/60) + (e.getMo()/15) + (e.getV()/10) + (5 * e.getB());
	    return result.toString();
	}
}
