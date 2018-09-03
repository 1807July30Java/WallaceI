package com.revature.compare;

//ctrl+shift+o for imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.oop.Car;

public class CompareCars {

	public static void main(String[] args) {
	
		List<Car> carList = new ArrayList<>();
		Car c1 = new Car(1993,"Saturn",50);
		Car c2 = new Car(1998,"ACME Cars",70);
		Car c3 = new Car(1970,"Tesla",10);
		Car c4 = new Car(2018,"Stark Industries",50);
		carList.add(c1);
		carList.add(c2);
		carList.add(c3);
		carList.add(c4);
		System.out.println("Cars before sort: ");
		for (Car c : carList) {
			System.out.println(c);
		}
		
		sortWithComparable(carList);
		
		sortWithManufacturerComparator(carList);
		
	}
	
	public static void sortWithComparable(List<Car> carList){
		Collections.sort(carList); //pass in Collection of comparable Objects
		System.out.println("Cars after sort: ");
		for (Car c : carList) {
			System.out.println(c);
		}
	}
	
	public static void sortWithManufacturerComparator(List<Car> carList){
		Collections.sort(carList, new ManufacturerComparator()); //pass in Collection of comparable Objects
		System.out.println("Cars after sort: ");
		for (Car c : carList) {
			System.out.println(c);
		}
	}

}
