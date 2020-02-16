package com.vivek.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(description="All details about the user")
public class User {
	
	@Id
	@GeneratedValue 
	private int id;	
	@Size(min=2, message="Name should have atleast two charcters")
	private String name;
	private String emailId;
	
	 public User() {}

	public User(int id, String name, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
	}



}
