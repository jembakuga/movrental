package com.exam.movierental.beans;

import java.math.BigDecimal;

import com.exam.movierental.entity.Movies;

public class MoviesBean {

	private Long id;

	private String title;

	private String genre;

	private int releaseYear;

	private BigDecimal rentalPrice;

	private int noOfCopies;
	
	public MoviesBean(Movies movies) {
		this.id = movies.getId();
		this.title = movies.getTitle();
		this.genre = movies.getGenre();
		this.releaseYear = movies.getReleaseYear();
		this.rentalPrice = movies.getRentalPrice();
		this.noOfCopies = movies.getNoOfCopies();
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
