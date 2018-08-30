package com.revature.service;

import com.revature.dao.AuthDAO;
import com.revature.dao.AuthDAOImpl;

public class AuthService {

	public AuthService() {
	}
	
	
	
	public static boolean isValidUser(String username, String password) {
		AuthDAO aut = new AuthDAOImpl();
		if (username != null && password != null) {
			return (aut.EmployeeAuth(username, password));
		} else {
			return false;
		}
	}
	

}
