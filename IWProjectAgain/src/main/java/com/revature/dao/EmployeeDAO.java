package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	public Employee getMyEmpInfo(String username);
	public List<Employee> getMyEmployeesById(int id);
	public String getTitle(int id);
	public String getNameById(int id);

}
