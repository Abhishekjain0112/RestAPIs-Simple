package com.cognizant.spring.restapi.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5829097892488376309L;

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
	
	
	
}
