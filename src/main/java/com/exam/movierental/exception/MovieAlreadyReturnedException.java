package com.exam.movierental.exception;

public class MovieAlreadyReturnedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MovieAlreadyReturnedException() {
		super("The movie is already returned.");
	}
	
	public MovieAlreadyReturnedException(String msg) {
		super(msg);
	}

}
