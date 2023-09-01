package com.exam.movierental.beans;

import com.exam.movierental.entity.User;

public class UserBean {

	private Long id;

	private String name;

	private String emailAddres;
	
	public UserBean() {
		
	}
	
	public UserBean(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.emailAddres = user.getEmailAddress();
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

	public String getEmailAddres() {
		return emailAddres;
	}

	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}
	
	
}
