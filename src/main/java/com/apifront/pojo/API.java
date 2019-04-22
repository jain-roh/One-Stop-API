package com.apifront.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class API {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long APIId;
@Column(name="APIName",nullable=false)
private String apiName;
@Column(name="APIDesc")
private String apiDesc;
@Column(name="APICode",nullable=false)
private String apiCode;
@Column(name="APICost",nullable=false)
private float apiCost;

@Column(name="APIActive")
private boolean apiActive;

public Business getBusiness() {
	return business;
}
public void setBusiness(Business business) {
	this.business = business;
}
public Set<User> getUser() {
	return user;
}
public void setUser(Set<User> user) {
	this.user = user;
}
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="fk_businessid")
private Business business;

@ManyToMany(mappedBy = "api",cascade= {CascadeType.PERSIST})
private Set<User> user=new HashSet<User>();


public long getAPIId() {
	return APIId;
}
public void setAPIId(long aPIId) {
	APIId = aPIId;
}
public String getApiName() {
	return apiName;
}
public void setApiName(String apiName) {
	this.apiName = apiName;
}
public String getApiDesc() {
	return apiDesc;
}
public void setApiDesc(String apiDesc) {
	this.apiDesc = apiDesc;
}
public String getApiCode() {
	return apiCode;
}
public void setApiCode(String apiCode) {
	this.apiCode = apiCode;
}
public float getApiCost() {
	return apiCost;
}
public void setApiCost(float apiCost) {
	this.apiCost = apiCost;
}
public boolean isApiActive() {
	return apiActive;
}
public void setApiActive(boolean apiActive) {
	this.apiActive = apiActive;
}


}
