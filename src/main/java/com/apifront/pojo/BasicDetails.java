package com.apifront.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class BasicDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long UserId;
	@Column(name="UserName",nullable=false)
	private String userName;
	@Column(name="UserPassword",nullable=false)
	private String userPassword;
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
