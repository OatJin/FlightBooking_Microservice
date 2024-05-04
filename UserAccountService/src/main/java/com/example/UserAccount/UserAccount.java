package com.example.UserAccount;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name="tbl_user_1")
public class UserAccount {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String name;
	String email;
	String username;
	public UserAccount() {
	}
	
	
	public UserAccount(Integer id, String name, String email, String username) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String info) {
		this.email = info;
	}
	public void setUser(String s) {
		this.username=s;
	}
	public String getStatus() {
		return username;
	}
	
}
