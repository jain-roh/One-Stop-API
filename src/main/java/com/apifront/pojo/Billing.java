package com.apifront.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Billing {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@OneToOne
private API api;

@OneToOne
private Services service;


@OneToOne
private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

private Date startDate;


private Date lastDate;


private boolean billed;

private boolean paid;

private double cost;

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getLastDate() {
	return lastDate;
}

public void setLastDate(Date lastDate) {
	this.lastDate = lastDate;
}

public boolean isBilled() {
	return billed;
}

public void setBilled(boolean billed) {
	this.billed = billed;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public API getApi() {
	return api;
}

public void setApi(API api) {
	this.api = api;
}

public Services getService() {
	return service;
}

public void setService(Services service) {
	this.service = service;
}



}
