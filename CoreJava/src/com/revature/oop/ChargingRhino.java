package com.revature.oop;

public class ChargingRhino extends Vehicle {
	
	private int hornLength = 10;

	public ChargingRhino(int yearMade) {
		super(yearMade);
	}

	public ChargingRhino() {
	}

	@Override
	public void go() {
		System.out.println("AAAAHHHHHHHHHHHH!");
	}

	@Override
	public String toString() {
		return "ChargingRhino [yearMade=" + yearMade + "]";
	}

	public int getHornLength() {
		return hornLength;
	}

	public void setHornLength(int hornLength) {
		this.hornLength = hornLength;
	}

}
