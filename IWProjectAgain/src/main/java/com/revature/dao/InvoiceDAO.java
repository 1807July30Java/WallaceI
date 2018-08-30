package com.revature.dao;

import java.time.LocalDate;
import java.util.List;

import com.revature.beans.Invoice;

public interface InvoiceDAO {
	
	public List<Invoice> getInvoices();
	public List<Invoice> getInvoicesById(int id);
	public List<Invoice> getMyPendingInvoices(int id);
	public List<Invoice> getMyResolvedInvoices(int id);
	
	public List<Invoice> getMyEmpPendingInvoices(int id);
	public List<Invoice> getAllEmpResolvedInvoices();
	
	public String getNameById(int id);
	public String getStatus(int status);
	
	public void addInvoice(int invoiceId, int id, int status, double amount, int imageId, int processedBy, LocalDate submit,
			LocalDate processed);
	public void addInvoiceByUser(String username, double amount);
	public void approveInvoice(int invoiceId, int id);
	public void denyInvoice(int invoiceId, int id);
	
	
}
