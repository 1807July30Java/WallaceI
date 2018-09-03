package com.revature.main;

import java.util.Arrays;

import com.revature.exception.OutOfFuelException;
//just saves us typing!! 
import com.revature.oop.*; //imports all classes in com.revature.oop package

public class Driver {

	public static void main(String[] args) {
		
		funWithExceptions();

	}

	public static void funWithInheritance() {

		// life without imports:
		// com.revature.oop.Truckski t = new com.revature.oop.Truckski();

		// life with imports:
		Truckski t = new Truckski();

		System.out.println(t.toString());

		t.setYearMade(1997);

		System.out.println(t.toString());

		t.go();

		t.turnLeft();

		t.turnRight();

		ChargingRhino cr = new ChargingRhino();

		cr.go();

	}
	
	public static void funWithIntArrays() {
		
		/*
		 * Arrays:
		 * elements must be the same type, length must be specified. 
		 * length is immutable once array is created. 
		 * elements of array are set to default value for that type. 
		 * java.util.Arrays (note the s) for useful methods. 
		 */
		
		//ways to declare arrays
		int[] intArray1 = { 3, 4, 5};
		int[] intArray2 = new int[6];
		int intArray3[] = new int[6]; //legal but horrible 
		
		System.out.println(intArray1.toString()); 
		System.out.println(Arrays.toString(intArray1));
		
		//not limited to one dimension
		int[][] intArray4 = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(Arrays.toString(intArray4));
		for( int[] i : intArray4) { //int i=0; i<intArray4.length; i++
			System.out.println(Arrays.toString(i));
		}
		
	}
	
	public static void funWithVehicleArraysAndCasting() {
		
		//create some vehicles
		Truckski t = new Truckski();
		t.setYearMade(1996);
		Truckski u = new Truckski();
		u.setYearMade(2018);
		Truckski v = new Truckski();
		v.setYearMade(1990);
		ChargingRhino cr = new ChargingRhino();
		cr.setYearMade(2005);
		
		//create array of vehicles
		Vehicle[] vehicleArray = new Vehicle[10];
		vehicleArray[0] = t;
		vehicleArray[1] = u;
		vehicleArray[7] = v;
		vehicleArray[3] = cr;
		
		System.out.println(Arrays.toString(vehicleArray));
		
		for( Vehicle vehicle : vehicleArray ) {
			
			if (vehicle != null) { //to prevent NullPointerExceptions
				try {
					vehicle.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
				//use instanceof operator to avoid ClassCastExceptions
				//((ChargingRhino) vehicle).setHornLength(40);
				System.out.println(vehicle.getClass());
			} 
		}
		
		//throw another exception...
		//vehicleArray[40] = new ChargingRhino(2008);
		
		/*
		 * casting:
		 * upcasting - happens implicitly, referring to a subtype as the supertype
		 * downcasting - needs to be explicitly done, referring to a supertype as its subtype
		 */
		
		//declare a Vehicle variable and assign a subtype (ChargingRhino) to it
		Vehicle veh = cr; //upcasting
		//compiler will not allow any Rhino-specific methods.. only sees declared type
		
		//declare a ChargingRhino variable and assign a supertype to it
		ChargingRhino rhino = (ChargingRhino) veh; //downcasting 
		//this is fine now
		rhino.getHornLength();
		
	}
	
	public static void funWithExceptions() {
		Car c1 = new Car(1982, "Ford", 40);
		Car c2 = new Car(2007, "Tesla", 3);
		try {
			c2.go();
			c1.go();
		} catch (OutOfFuelException e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("this always runs");
		}
		
	}
	
	

}
