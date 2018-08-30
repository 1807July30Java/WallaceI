package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.beans.Employee;
import com.revature.beans.Invoice;
import com.revature.util.ConnectionUtil;

public class InvoiceDAOImpl implements InvoiceDAO {

	private static String filename = "connection.properties";

	@Override
	public List<Invoice> getInvoices() {
		List<Invoice> inv = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM INVOICES";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int invoiceId = rs.getInt("INVOICE_ID");
				int uid = rs.getInt("USER_ID");
				int status = rs.getInt("STATUS");
				double amount = rs.getDouble("AMOUNT");
				int imageId = rs.getInt("IMAGE_ID");
				int processedBy = rs.getInt("PROCESSEDBY");
				LocalDate submitDate = rs.getDate("SUBMITDATE").toLocalDate();
				LocalDate processDate = rs.getDate("PROCESSDATE").toLocalDate();
				String idName = getNameById(uid);
				String statusName = getStatus(status);
				String processedName = getNameById(processedBy);
				Invoice newInv = new Invoice(invoiceId, idName, statusName, amount, imageId, processedName, submitDate,
						processDate);
				inv.add(newInv);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return inv;
	}

	@Override
	public List<Invoice> getInvoicesById(int id) { // get EMPLOYEE invoices
		List<Invoice> inv = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM INVOICES WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int invoiceId = rs.getInt("INVOICE_ID");
				int uid = rs.getInt("USER_ID");
				int status = rs.getInt("STATUS");
				double amount = rs.getDouble("AMOUNT");
				int imageId = rs.getInt("IMAGE_ID");
				int processedBy = rs.getInt("PROCESSEDBY");
				LocalDate submitDate = rs.getDate("SUBMITDATE").toLocalDate();
				LocalDate processDate = rs.getDate("PROCESSDATE").toLocalDate();
				String idName = getNameById(uid);
				String statusName = getStatus(status);
				String processedName = getNameById(processedBy);
				Invoice newInv = new Invoice(invoiceId, idName, statusName, amount, imageId, processedName, submitDate,
						processDate);
				inv.add(newInv);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return inv;
	}

	@Override
	public List<Invoice> getMyPendingInvoices(int id) {
		List<Invoice> inv = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM INVOICES WHERE USER_ID = ? AND STATUS = 0";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int invoiceId = rs.getInt("INVOICE_ID");
				int uid = rs.getInt("USER_ID");
				int status = rs.getInt("STATUS");
				double amount = rs.getDouble("AMOUNT");
				int imageId = rs.getInt("IMAGE_ID");
				int processedBy = rs.getInt("PROCESSEDBY");
				LocalDate submitDate = rs.getDate("SUBMITDATE").toLocalDate();
				LocalDate processDate = rs.getDate("PROCESSDATE").toLocalDate();
				String idName = getNameById(uid);
				String statusName = getStatus(status);
				String processedName = getNameById(processedBy);
				Invoice newInv = new Invoice(invoiceId, idName, statusName, amount, imageId, processedName, submitDate,
						processDate);
				inv.add(newInv);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return inv;
	}

	@Override
	public List<Invoice> getMyResolvedInvoices(int id) {
		List<Invoice> inv = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM INVOICES WHERE (USER_ID = ?) AND (STATUS = 1 OR STATUS = 2)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int invoiceId = rs.getInt("INVOICE_ID");
				int uid = rs.getInt("USER_ID");
				int status = rs.getInt("STATUS");
				double amount = rs.getDouble("AMOUNT");
				int imageId = rs.getInt("IMAGE_ID");
				int processedBy = rs.getInt("PROCESSEDBY");
				LocalDate submitDate = rs.getDate("SUBMITDATE").toLocalDate();
				LocalDate processDate = rs.getDate("PROCESSDATE").toLocalDate();
				String idName = getNameById(uid);
				String statusName = getStatus(status);
				String processedName = getNameById(processedBy);
				Invoice newInv = new Invoice(invoiceId, idName, statusName, amount, imageId, processedName, submitDate,
						processDate);
				inv.add(newInv);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return inv;
	}

	@Override
	public List<Invoice> getMyEmpPendingInvoices(int id) {
		List<Invoice> inv = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT EMPLOYEES.USER_ID, INVOICES.INVOICE_ID, INVOICES.STATUS, INVOICES.AMOUNT, INVOICES.IMAGE_ID, INVOICES.PROCESSEDBY, INVOICES.SUBMITDATE FROM INVOICES RIGHT OUTER JOIN EMPLOYEES ON INVOICES.USER_ID = EMPLOYEES.USER_ID WHERE (EMPLOYEES.REPORTSTO = ?) AND (INVOICES.STATUS = 0)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int uid = rs.getInt("USER_ID");
				int invoiceId = rs.getInt("INVOICE_ID");
				int status = rs.getInt("STATUS");
				double amount = rs.getDouble("AMOUNT");
				int imageId = rs.getInt("IMAGE_ID");
				int processedBy = rs.getInt("PROCESSEDBY");
				LocalDate submitDate = rs.getDate("SUBMITDATE").toLocalDate();
				String idName = getNameById(uid);
				String statusName = getStatus(status);
				String processedName = getNameById(processedBy);
				Invoice newInv = new Invoice(invoiceId, idName, statusName, amount, imageId, processedName, submitDate);
				inv.add(newInv);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return inv;
	}

	@Override
	public List<Invoice> getAllEmpResolvedInvoices() {
		List<Invoice> inv = new ArrayList<>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM INVOICES WHERE STATUS = 1 OR STATUS = 2";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				int invoiceId = rs.getInt("INVOICE_ID");
				int uid = rs.getInt("USER_ID");
				int status = rs.getInt("STATUS");
				double amount = rs.getDouble("AMOUNT");
				int imageId = rs.getInt("IMAGE_ID");
				int processedBy = rs.getInt("PROCESSEDBY");
				LocalDate submitDate = rs.getDate("SUBMITDATE").toLocalDate();
				LocalDate processDate = rs.getDate("PROCESSDATE").toLocalDate();
				String idName = getNameById(uid);
				String statusName = getStatus(status);
				String processedName = getNameById(processedBy);
				Invoice newInv = new Invoice(invoiceId, idName, statusName, amount, imageId, processedName, submitDate,
						processDate);
				inv.add(newInv);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return inv;
	}

	@Override
	public String getNameById(int id) {
		EmployeeDAO empImp = new EmployeeDAOImpl();
		return empImp.getNameById(id);
	}

	@Override
	public String getStatus(int status) {
		if (status == 0) {
			return "Pending";
		} else if (status == 1) {
			return "Approved";
		} else if (status == 2) {
			return "Denied";
		}
		return "";
	}

	@Override
	public void addInvoice(int invoiceId, int id, int status, double amount, int imageId, int processedBy,
			LocalDate submit, LocalDate processed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addInvoiceByUser(String username, double amount) {
		EmployeeDAO empImp = new EmployeeDAOImpl();
		Employee emp = empImp.getMyEmpInfo(username);
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "INSERT INTO INVOICES (USER_ID, AMOUNT, SUBMITDATE) VALUES (?, ?, CURRENT_DATE)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, emp.getId());
			pstmt.setDouble(2, amount);
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void approveInvoice(int invoiceId, int id) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE INVOICES SET STATUS = 1, PROCESSEDBY = ?, PROCESSDATE = CURRENT_DATE WHERE INVOICE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, invoiceId);
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void denyInvoice(int invoiceId, int id) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE INVOICES SET STATUS = 2, PROCESSEDBY = ?, PROCESSDATE = CURRENT_DATE WHERE INVOICE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, invoiceId);
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
