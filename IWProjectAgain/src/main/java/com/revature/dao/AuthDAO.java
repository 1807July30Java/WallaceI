package com.revature.dao;

import com.revature.beans.Auth;

public interface AuthDAO {
	
	public Auth getAuthByUsername(String username);
	public boolean EmployeeAuth(String username, String password);
}
