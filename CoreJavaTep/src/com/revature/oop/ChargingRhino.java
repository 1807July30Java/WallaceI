package com.revature.oop;

import java.util.Arrays;

public class ChargingRhino {

	public ChargingRhino() {
		// TODO Auto-generated constructor stub
	}

	public static void funWithInheritance() {
		
	}
	public static void funWithArrays() {
		/*
		 * Arrays:
		 * elements must be the same type, length must be specified
		 * length is immutable once array is created
		 * elements of array set to default value for that type
		 * java.util.Arrays (note the s, plural) for useful methods.
		 */
		
		//ways to declare arrays
		int[] intArray1 = {3, 4, 5};
		int[] intArray2 = new int[6];
		int intArray3[] = new int[10]; //don't do this ever, legal, but ugly
		
		System.out.println(intArray1.toString());
		System.out.println(Arrays.toString(intArray1));
		
		//not limite to one dimension
		int][] intArray4 = {{1,2,3},{4,5,6},{7,8,9}};
		for (int[i] 1 : intArray4) { //int i = 0; i<intArray4.length; i++
			System.out.println(Array.toString(i));
			
		}
	}
	public static void funWithVehiclesArrays() {
		
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
		vehicleArray[2] = v;
		vehicleArray[3] = cr;
		
		System.out.println(Arrays.toString(vehicleArray));
		
		for( Vehicle vehicle : vehicleArray) {
			
			if (vehicle != null) { //prevent null pointer exceptions
				vehicle.go();
				//use instance of operator to avoid ClassCastExceptions
				//((ChargingRhino)vehicle).setHornLength(40);
				System.out.println(Vehicle.getClass());
			}
			
			//throw another exception
			//vehicleArray[40]
			
			/*
			 * casting:
			 * upcasting - happens implictily, referring to a subtype as a supertype
			 * downcasting - needs to be explicitly done, referring to a supertype as a subtype
			 */
			
			//declare a vehicle variable and assign a subtype (charging Rhino) to it
			Vehicle veh = cr; //upcasting
			//compiler will not allow any Rhino-specific methods, only sees declare type
			
			//declare a ChargingRhino variable and assign  supertype to it
			ChargingRhino rhino = (ChargingRHino) veh;
			//this is fine now
			rhino
			
		}
	}

}
