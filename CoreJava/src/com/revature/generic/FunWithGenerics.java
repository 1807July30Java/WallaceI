package com.revature.generic;

import java.lang.reflect.Field;

import com.revature.oop.Car;

public class FunWithGenerics {
	
	public static void main(String[] args) {
		
		funWithReflection();
		
		
	}
	
	public static void funWithReflection() {
		
		//get Car class using reflection
		try {
			
			Class clazz = Class.forName("com.revature.oop.Car");
			System.out.println(clazz.getSimpleName());
			
			//print declared fields
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				System.out.println(f.getName()+" with a datatype of "+f.getType());
			}
			
			//new instance of Car
			Car c1 = (Car) clazz.newInstance();
			Field tankPercentage = clazz.getDeclaredField("tankPercentage");
			tankPercentage.setAccessible(true);
			tankPercentage.set(c1, 50);
			System.out.println(c1);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public FunWithGenerics() {}

}
