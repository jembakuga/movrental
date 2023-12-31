package com.exam.movierental.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.exam.movierental.beans.MovieBean;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String genre;

	private int releaseYear;

	private BigDecimal rentalPrice;

	private int noOfCopies;

	@OneToMany(mappedBy = "movie")
	@JsonManagedReference
	private Set<Rental> rentalsSet = new HashSet<Rental>();

	public Movie() {
	}

	public Movie(MovieBean movieBean) {
		this.id = movieBean.getId();
		this.title = movieBean.getTitle();
		this.genre = movieBean.getGenre();
		this.releaseYear = movieBean.getReleaseYear();
		this.rentalPrice = movieBean.getRentalPrice();
		this.noOfCopies = movieBean.getNoOfCopies();
	}
	
	public Movie(Long id, String title, String genre, int releaeYear, BigDecimal rentalPrice, int noOfCopies) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaeYear;
		this.rentalPrice = rentalPrice;
		this.noOfCopies = noOfCopies;
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

	public Set<Rental> getRentalsSet() {
		return rentalsSet;
	}

	public void setRentalsSet(Set<Rental> rentalsSet) {
		this.rentalsSet = rentalsSet;
	}

}
