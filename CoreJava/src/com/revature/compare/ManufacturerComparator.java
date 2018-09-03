package com.revature.compare;

import java.util.Comparator;

import com.revature.oop.Vehicle;

public class ManufacturerComparator implements Comparator<Vehicle>{

	public ManufacturerComparator() {
	}

	@Override
	public int compare(Vehicle arg0, Vehicle arg1) {
		return arg0.getManufacturer().compareTo(arg1.getManufacturer());
	}

}
