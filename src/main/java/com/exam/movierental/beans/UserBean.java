package com.exam.movierental.beans;

import java.util.ArrayList;
import java.util.List;

import com.exam.movierental.entity.Rental;
import com.exam.movierental.entity.User;

public class UserBean {

	private Long id;

	private String name;

	private String emailAddress;
	
	private List<RentalBean> rentalBeanList = new ArrayList<RentalBean>();
	
	public UserBean() {
		
	}
	
	public UserBean(Long id, String name, String emailAddress) {
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
	}
	
	public UserBean(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.emailAddress = user.getEmailAddress();
		for(Rental rental : user.getRentalList()) {
			RentalBean bean = new RentalBean(rental);
			this.rentalBeanList.add(bean);
		}
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

	public List<RentalBean> getRentalBeanList() {
		return rentalBeanList;
	}

	public void setRentalBeanList(List<RentalBean> rentalBeanList) {
		this.rentalBeanList = rentalBeanList;
	}
	
	
}
