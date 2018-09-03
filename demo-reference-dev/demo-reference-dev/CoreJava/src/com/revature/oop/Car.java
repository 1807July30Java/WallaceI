package com.revature.oop;

import com.revature.exception.OutOfFuelException;

public class Car extends Vehicle implements Steerable {

	public Car(int yearMade, String manufacturer, int tankPercentage) {
		super(yearMade, manufacturer);
		this.tankPercentage = tankPercentage;
	}

	private int tankPercentage;

	public Car() {
	}

	@Override
	public void go() throws OutOfFuelException {
		if(this.tankPercentage < 5) {
			throw new OutOfFuelException();
		} else {
			System.out.println("Car is going forward");
		}
		
	}

	public int getTankPercentage() {
		return tankPercentage;
	}

	public void setTankPercentage(int tankPercentage) {
		this.tankPercentage = tankPercentage;
	}

	

	@Override
	public void turnLeft() {
		System.out.println("Car is turning left");
	}

	@Override
	public void turnRight() {
		System.out.println("Car is turning right");
		
	}

	@Override
	public String toString() {
		return "Car [tankPercentage=" + tankPercentage + ", yearMade=" + yearMade + ", manufacturer=" + manufacturer
				+ "]";
	}

}
