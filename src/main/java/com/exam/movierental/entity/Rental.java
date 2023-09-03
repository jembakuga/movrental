package com.exam.movierental.entity;

import java.sql.Timestamp;

import com.exam.movierental.beans.MovieBean;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID", updatable = false)
	@JsonBackReference
	private User user;

	@ManyToOne
	@JoinColumn(name = "MOVIES_ID", updatable = false)
	@JsonBackReference
	private Movie movie;

	private Timestamp rentalDate;

	private Timestamp dueDate;

	private String returned;

	public Rental() {
	}

	public Rental(Long id, Movie movie, Timestamp rentalDate, Timestamp dueDate) {
		this.id = id;
		this.movie = movie;
		this.rentalDate = rentalDate;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
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

	public String getReturned() {
		return returned;
	}

	public void setReturned(String returned) {
		this.returned = returned;
	}

}
