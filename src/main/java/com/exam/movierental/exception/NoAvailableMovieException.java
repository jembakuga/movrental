package com.exam.movierental.exception;

public class NoAvailableMovieException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoAvailableMovieException() {
		super("There is no available copy for rent.");
	}
	
	public NoAvailableMovieException(String msg) {
		super(msg);
	}

}
