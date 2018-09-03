package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmpDAO {
	
	public List<Employee> getEmployee();
	public Employee getEmployeeByUsername(String username);
//	public boolean getEmployeeByUsername(String username);
//	public Employee getEmployeeByPassword(String username);

}
