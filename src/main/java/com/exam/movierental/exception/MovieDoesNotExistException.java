package com.exam.movierental.exception;

public class MovieDoesNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public MovieDoesNotExistException() {
		super("Movie does not exist.");
	}
	
	public MovieDoesNotExistException(String msg) {
		super(msg);
	}

}
