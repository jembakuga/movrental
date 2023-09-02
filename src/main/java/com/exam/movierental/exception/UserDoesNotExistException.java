package com.exam.movierental.exception;

public class UserDoesNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UserDoesNotExistException() {
		super("User does not exist.");
	}
	
	public UserDoesNotExistException(String msg) {
		super(msg);
	}

}
