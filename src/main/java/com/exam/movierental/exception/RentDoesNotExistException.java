package com.exam.movierental.exception;

public class RentDoesNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public RentDoesNotExistException() {
		super("Rent does not exist.");
	}
	
	public RentDoesNotExistException(String msg) {
		super(msg);
	}

}
