package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static String filename = "connection.properties";

	@Override
	public List<Employee> getEmployees() { //Managers Only
		List<Employee> emp = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEES";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String email = rs.getString("EMAIL");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				int tid = rs.getInt("TITLE_ID");
				int rid = rs.getInt("REPORTSTO");
				String title = getTitle(tid);
				String report = getNameById(rid);
				Employee newEmp = new Employee(id, email, fname, lname, title, report);
				emp.add(newEmp);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee getMyEmpInfo(String username) { //All Employees can access this function
		AuthDAO aut = new AuthDAOImpl();
		int empId = aut.getAuthByUsername(username).getId();
		PreparedStatement pstmt = null;
		Employee emp = null;
		System.out.println(empId);
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			System.out.println("Success");
			String sql = "SELECT * FROM EMPLOYEES WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("USER_ID");
				String email = rs.getString("EMAIL");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				int tid = rs.getInt("TITLE_ID");
				int rid = rs.getInt("REPORTSTO");
				String title = getTitle(tid);
				String report = getNameById(rid);
				emp = new Employee(id, email, fname, lname, title, report);
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public List<Employee> getMyEmployeesById(int id) { //Managers Only: Gets their employees by their User ID
		List<Employee> emp = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			System.out.println("Success");
			String sql = "SELECT * FROM EMPLOYEES WHERE REPORTSTO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int uid = rs.getInt("USER_ID");
				String email = rs.getString("EMAIL");
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				int tid = rs.getInt("TITLE_ID");
				int rid = rs.getInt("REPORTSTO");
				String title = getTitle(tid);
				String report = getNameById(rid);
				Employee newEmp = new Employee(uid, email, fname, lname, title, report);
				emp.add(newEmp);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public String getTitle(int id) { //converts Title IDs into Title Names
		TitleDAOImpl titleImp = new TitleDAOImpl();
		return titleImp.getTitleById(id);
	}

	@Override
	public String getNameById(int id) {
		if(id == 0) {
			return "";
		}
		String fullName = null;
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEES WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String fname = rs.getString("FIRST_NAME");
				String lname = rs.getString("LAST_NAME");
				fullName = fname+" "+lname;
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return fullName;
	}

	

}
