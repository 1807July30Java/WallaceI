package com.revature.oop;

public class Truckski extends Vehicle implements Steerable {

	public Truckski() {
		super();
	}

	@Override
	public void go() {
		//sysout+ctrl+space!! 
		System.out.println("truckski is going!");
		
	}

	@Override
	public String toString() {
		return "Truckski [yearMade=" + yearMade + "]";
	}

	@Override
	public void turnLeft() {
		System.out.println("turn truckski handlebars CCW");
	}

	@Override
	public void turnRight() {
		System.out.println("turn truckski handlebars CW");
	}

}
