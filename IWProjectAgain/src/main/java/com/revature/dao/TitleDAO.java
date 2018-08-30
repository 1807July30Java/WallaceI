package com.revature.dao;

import java.util.List;

import com.revature.beans.Title;



public interface TitleDAO {
	
	public List<Title> getTitles();
	public String getTitleById(int id);

}
