package com.revature.beans;

public class Employee {
	
	
	public Employee(int id, String email, String firstname, String lastname, int titleId, int reportsToId) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.titleId = titleId;
		this.reportsToId = reportsToId;
	}
	
	public Employee(int id, String email, String firstname, String lastname, String title, String reportsTo) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.title = title;
		this.reportsTo = reportsTo;
	}

	public Employee() {
		super();
	}
	
	private int id;
	private String email;
	private String firstname;
	private String lastname;
	private String title;
	private String reportsTo;
	private int titleId;
	private int reportsToId;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}
	
	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public int getReportsToId() {
		return reportsToId;
	}

	public void setReportsToId(int reportsToId) {
		this.reportsToId = reportsToId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", title=" + title + ", reportsTo=" + reportsTo + ", titleId=" + titleId + ", reportsToId="
				+ reportsToId + "]";
	}


}
