package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Cave;

public class CaveDAOTest {
	
	private static CaveDAO cd;
	private static Cave c;
	
	@BeforeClass
	public static void setup() {
		cd = new CaveDAOImpl();
		c = new Cave("testCave",5);
	}
	
	/*
	 * GOAL: construct our saveCave method in CaveDAO from requirements using TDD
	 * REQUIREMENTS: 
	 * 1. returns a boolean value and takes a Cave value 
	 * 2. returns false is provided Cave is null 
	 * 3. returns true if cave is successfully inserted
	 */
	
	@Test
	public void testNullCaveReturnsFalse() {
		assertFalse(cd.saveCave(null));
	}
	
	@Test
	public void testAddCaveReturnsTrue() {
		assertTrue(cd.saveCave(c));
	}
	
	//think about cleanup 
	//reset your test environment for every run 
	//for now, use @After or @AfterClass 

}
