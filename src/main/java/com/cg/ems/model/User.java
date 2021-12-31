package com.cg.ems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="user_tbl")
public class User {
	
	@Id
	int userId;
	@Column(name="pwd")
	String password;
	@Column(name="role")
	@NotNull
	String role;
	@NotNull
	@Column(name ="result")
	int result;
	public User() {
		super();
	}
	
	public User(int userId, String password, String role, int result) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.result = result;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", result=" + result + "]";
	}
	
	

}
