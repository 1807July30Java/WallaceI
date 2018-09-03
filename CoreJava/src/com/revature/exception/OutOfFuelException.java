package com.revature.exception;

public class OutOfFuelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8357892614181422229L;

	public OutOfFuelException() {
		super("not enough fuel");
	}

}
