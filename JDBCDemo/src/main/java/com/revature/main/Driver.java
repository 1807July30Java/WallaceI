package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOImpl;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		init();
	
	}
	
	static void funWithCallableStatements() {
		
		BearDAO bd = new BearDAOImpl();
		System.out.println(bd.getBearById(8));
		System.out.println(bd.feedBear(8, 55, 3));
		System.out.println(bd.getBearById(8));
		
	}
	
	static void init() {
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CaveDAO cd = new CaveDAOImpl();
		List<Cave> caves = cd.getCaves();
		for (Cave c : caves) {
			System.out.println(c);
		}
		
		//watch out for null caves! 
		Cave c = cd.getCaveById(2);
		System.out.println(c);
		
		//get some warning logs 
		Cave c1 = cd.getCaveById(70);
		cd.saveCave(null);
		/*BearDAO bd = new BearDAOImpl();
		List<Bear> bears = bd.getBears();
		for (Bear b : bears) {
			System.out.println(b);
		}*/
		
	}

}
