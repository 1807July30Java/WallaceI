package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.beans.Auth;
import com.revature.util.ConnectionUtil;

public class AuthDAOImpl implements AuthDAO {
	
	private static String filename = "connection.properties";


	
	@Override
	public Auth getAuthByUsername(String username) {
		PreparedStatement pstmt = null;
		Auth aut = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			System.out.println("Success");
			String sql = "SELECT * FROM AUTH WHERE USER_NAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("USER_ID");
				String user = rs.getString("USER_NAME");
				String pass = rs.getString("PASSWORD");
				aut = new Auth(id, user, pass);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return aut;
	}
	
	
	@Override
	public boolean EmployeeAuth(String username, String password) {
		Auth aut = getAuthByUsername(username);
		if(aut != null) {
			if(password.equals(aut.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
}
