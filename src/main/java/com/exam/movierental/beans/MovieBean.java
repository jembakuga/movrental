package com.exam.movierental.beans;

import java.math.BigDecimal;

import com.exam.movierental.entity.Movie;

public class MovieBean {

	private Long id;

	private String title;

	private String genre;

	private int releaseYear;

	private BigDecimal rentalPrice;

	private int noOfCopies;

	public MovieBean(Long id, String title, String genre, int releaeYear, BigDecimal rentalPrice, int noOfCopies) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaeYear;
		this.rentalPrice = rentalPrice;
		this.noOfCopies = noOfCopies;
	}

	public MovieBean(Movie movie) {
		this.id = movie.getId();
		this.title = movie.getTitle();
		this.genre = movie.getGenre();
		this.releaseYear = movie.getReleaseYear();
		this.rentalPrice = movie.getRentalPrice();
		this.noOfCopies = movie.getNoOfCopies();
	}

	
	
	public MovieBean() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public BigDecimal getRentalPrice() {
		return rentalPrice;
	}

	public void setRentalPrice(BigDecimal rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

}
