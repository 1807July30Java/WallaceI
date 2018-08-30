package com.revature.beans;

import java.time.LocalDate;

public class Invoice {

	public Invoice(int invoiceId, int id, int status, double amount, int imageId, int processedBy, LocalDate submit,
			LocalDate processed) {
		super();
		this.invoiceId = invoiceId;
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.imageId = imageId;
		this.processedBy = processedBy;
		this.submit = submit;
		this.processed = processed;
	}
	
	public Invoice(int invoiceId, String idName, String statusName, double amount, int imageId, String processedByName, LocalDate submit,
			LocalDate processed) {
		super();
		this.invoiceId = invoiceId;
		this.idName = idName;
		this.statusName = statusName;
		this.amount = amount;
		this.imageId = imageId;
		this.processedByName = processedByName;
		this.submit = submit;
		this.processed = processed;
	}
	
	public Invoice(int invoiceId, String idName, String statusName, double amount, String processedByName, LocalDate submit,
			LocalDate processed) {
		super();
		this.invoiceId = invoiceId;
		this.idName = idName;
		this.statusName = statusName;
		this.amount = amount;
		this.processedByName = processedByName;
		this.submit = submit;
		this.processed = processed;
	}
	
	public Invoice(int invoiceId, String idName, String statusName, double amount, int imageId, String processedByName, LocalDate submit) {
		super();
		this.invoiceId = invoiceId;
		this.idName = idName;
		this.statusName = statusName;
		this.amount = amount;
		this.processedByName = processedByName;
		this.submit = submit;
	}

	public Invoice() {
		super();
	}

	private int invoiceId;
	private int id;
	private String idName;
	private int status;
	private String statusName;
	private double amount;
	private int imageId;
	private int processedBy;
	private String processedByName;
	private LocalDate submit;
	private LocalDate processed;
	
	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getProcessedBy() {
		return processedBy;
	}

	public void setProcessedBy(int processedBy) {
		this.processedBy = processedBy;
	}

	public String getProcessedByName() {
		return processedByName;
	}

	public void setProcessedByName(String processedByName) {
		this.processedByName = processedByName;
	}

	public LocalDate getSubmit() {
		return submit;
	}

	public void setSubmit(LocalDate submit) {
		this.submit = submit;
	}

	public LocalDate getProcessed() {
		return processed;
	}

	public void setProcessed(LocalDate processed) {
		this.processed = processed;
	}

	

}
