package com.revature.oop;

public abstract class Vehicle implements Comparable<Vehicle> {

	public Vehicle(int yearMade, String manufacturer) {
		super();
		this.yearMade = yearMade;
		this.manufacturer = manufacturer;
	}

	// instance field, will be inherited by subtypes
	protected int yearMade;
	protected String manufacturer;

	public Vehicle(int yearMade) {
		super();
		this.yearMade = yearMade;
	}

	public abstract void go() throws Exception;

	public Vehicle() {
		super();
	}

	public int getYearMade() {
		return yearMade;
	}

	public void setYearMade(int yearMade) {
		this.yearMade = yearMade;
	}

	

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Vehicle [yearMade=" + yearMade + ", manufacturer=" + manufacturer + "]";
	}
	
	@Override
	public int compareTo(Vehicle v) {
		//return this.yearMade.compareTo(v.getYearMade()); //this would require yearMade to be an Integer, not int
		return this.yearMade - v.getYearMade();
	}

}
