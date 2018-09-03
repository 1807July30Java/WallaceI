package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmpDAOImpl implements EmpDAO {
	
	private static String filename = "connection.properties";

	public EmpDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	/***********************************************************************************************************************************************/

	//Getting client Info by username	
	
//	@Override
//	public boolean getEmployeeByUsername(String username) {
//		PreparedStatement pstmt = null;
//		boolean emp = false;
//		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
////			System.out.println("Success");
//			String sql = "SELECT USER_NAME FROM AUTH WHERE USER_NAME = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, username);
//			ResultSet rs = pstmt.executeQuery();
////			System.out.println(rs.getString("USER_NAME"));
//			while (rs.next()) {
//				System.out.println(rs.getString("USER_NAME")+ " = "+ username);
//				if(rs.getString("USER_NAME") == username) {
//					System.out.println("Hello?");
//					emp = true;
//				}
//				System.out.println(rs.getString("USER_NAME")+ " = "+ username);
//			}
//			con.close();
//		} catch (SQLException e) {
//			System.out.println("This happened");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("that happened");
//			e.printStackTrace();
//		}
//
//		return emp;
//	}
	
	@Override
	public Employee getEmployeeByUsername(String username) {
		PreparedStatement pstmt = null;
		Employee emp = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			System.out.println("Success");
			String sql = "SELECT * FROM AUTH WHERE USER_NAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
//			System.out.println(rs.getString("USER_NAME"));
			while (rs.next()) {
				
				int id = rs.getInt("USER_ID");
				System.out.println(id);
				String user = rs.getString("USER_NAME");
				System.out.println(user);
				String pass = rs.getString("PASSWORD");
				System.out.println(pass);
				emp = new Employee(id, user, pass);
				
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("This happened");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("that happened");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("How badly did I fuck up?");
			e.printStackTrace();
		}

		return emp;
	}
	
	public boolean EmployeeAuth(String username, String password) {
		Employee emp = getEmployeeByUsername(username);
		if(emp != null) {
			if(password.equals(emp.getPassword())) {
				System.out.println("GOT 'EM!!");
				return true;
			}
//			System.out.println(emp.getPassword());
			
		}
		System.out.println("Words");
		return false;
		
		
//		if ((emp.getPassword() == password)) {
//			System.out.println("Invalid username and password");
//			return true;
//		}
//		
//		return false;
		
	}

	


	/***********************************************************************************************************************************************/
	//Check for Password
	
//	public Client getClientInfoPass(String password) {
//		
//		
//		PreparedStatement pstmt = null;
//		Client client = null;
//		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
//
//			String sql = "SELECT * FROM BANK_CLIENT WHERE PASSWORD= ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, password);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()){
//				double userID = rs.getInt("CLIENT_ID");
//				String firstName = rs.getString("FIRST_NAME");
//				String lastName = rs.getString("LAST_NAME");
//				String username = rs.getString("USER_NAME");
//				
//				
//				client = new Client(userID, firstName, lastName, password,username);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		if (client == null) {
//			return null;
//		}
//		return client;
//	
//	}
//
//	
//	
//	/***********************************************************************************************************************************************/
//	
//public Client getClientInfoAuth(String username,String pass) {
//	BankClientDAOImp bc = new BankClientDAOImp();
//
//	
//		PreparedStatement pstmt = null;
//		Client client = null;
//		
//		if ((bc.getClientInfo(username)== null)||(bc.getClientInfoPass(pass)==null)) {
//			System.out.println("Invalid username and password");
//			return null;
//		}
//		
//		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
//
//			String sql = "SELECT * FROM BANK_CLIENT WHERE USER_NAME= ? AND PASSWORD=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, username);
//			pstmt.setString(2, pass);
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()){
//				double userID = rs.getInt("CLIENT_ID");
//				String firstName = rs.getString("FIRST_NAME");
//				String lastName = rs.getString("LAST_NAME");
//				String password = rs.getString("PASSWORD");
//				
//				
//				client = new Client(userID, firstName, lastName, password,username);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		;
//		return client;
//	
//	}

}
