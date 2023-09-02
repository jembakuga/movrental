package com.exam.movierental.beans;

import java.sql.Timestamp;

import com.exam.movierental.entity.Rental;

public class RentalBean {

	private Long id;

	private MovieBean movieBean;

	private Timestamp rentalDate;

	private Timestamp dueDate;

	public RentalBean() {

	}

	public RentalBean(Rental rental) {
		this.id = rental.getId();
		this.movieBean = new MovieBean(rental.getMovie());
		this.rentalDate = rental.getRentalDate();
		this.dueDate = rental.getDueDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MovieBean getMovieBean() {
		return movieBean;
	}

	public void setMovieBean(MovieBean movieBean) {
		this.movieBean = movieBean;
	}

	public Timestamp getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

}
