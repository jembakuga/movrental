package com.exam.movierental.entity;

import java.util.ArrayList;
import java.util.List;

import com.exam.movierental.beans.UserBean;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String emailAddress;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Rental> rentalList = new ArrayList<Rental>();
	
	public User() {
		
	}
	
	public User(UserBean userBean) {
		this.name = userBean.getName();
		this.emailAddress = userBean.getEmailAddress();
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

	public List<Rental> getRentalList() {
		return rentalList;
	}

	public void setRentalList(List<Rental> rentalList) {
		this.rentalList = rentalList;
	}

	
	
	

}
