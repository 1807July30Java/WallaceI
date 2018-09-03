package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	//this is terrible, don't do it this way! 
	public static Connection getConnection() throws SQLException {
		String url = "";
		String username = "";
		String password = "";
		return DriverManager.getConnection(url, username, password);
	}
	
	//better, if you don't push the connection.properties file
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	}

}
