package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Title;
import com.revature.util.ConnectionUtil;

public class TitleDAOImpl implements TitleDAO {
	
	private static String filename = "connection.properties";

	@Override
	public List<Title> getTitles() {
		List<Title> ttl = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM TITLES";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("TITLE_ID");
				String name = rs.getString("TITLE_NAME");
				Title newTTL = new Title(id, name);
				ttl.add(newTTL);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return ttl;
	}

	@Override
	public String getTitleById(int id) {
		String title = null;
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM TITLES WHERE TITLE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("TITLE_NAME");
				title = name;
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return title;
	}

}
