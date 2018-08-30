package com.revature.beans;

public class Title {

	public Title(int titleId, String titleName) {
		super();
		this.titleId = titleId;
		this.titleName = titleName;
	}
	
	public Title(String titleName) {
		super();
		this.titleName = titleName;
	}
	
	public Title() {
		super();
	}
	
	private int titleId;
	private String titleName;
	
	
	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

}
