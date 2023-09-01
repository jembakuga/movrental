package com.exam.movierental.entity;

import java.util.HashSet;
import java.util.Set;

import com.exam.movierental.beans.UserBean;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String emailAddress;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private Set<Rental> rentalsSet = new HashSet<Rental>();
	
	public User() {
		
	}
	
	public User(UserBean userBean) {
		this.name = userBean.getName();
		this.emailAddress = userBean.getEmailAddres();
		this.id = userBean.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set<Rental> getRentalsSet() {
		return rentalsSet;
	}

	public void setRentalsSet(Set<Rental> rentalsSet) {
		this.rentalsSet = rentalsSet;
	}
	
	

}
