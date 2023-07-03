package com.example.Bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="users_table")
@Entity(name="UsersEntity")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int uid;
	String username;
	String password;
	String email;
	String phonenum;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public UsersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersEntity(int uid, String username, String password, String email, String phonenum) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenum = phonenum;
	}
	
	
}
