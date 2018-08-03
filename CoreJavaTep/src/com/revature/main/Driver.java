package com.revature.main;

import com.revature.oop.*;//imports call classes in com.revature.oop package

public class Driver {

	public static void main(String[] args) {
		
		//life without imports:
		//com.revature.oop.Truckski = new 
		
		//life with imports
		Truckski t = new Truckski();
		System.out.println(t.toString());
		
		t.setYearMade(1997);
		int yearMade = t.getYearMade();
		System.out.println(t.toString());
		t.go();
		t.turnLeft();
		t.turnRight();
		ChargingRhino cr = new ChargingRhino();
		cr.go();

	}

}
