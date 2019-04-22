package com.apifront.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Services {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long ServicesId;
@Column(name="ServicesName",nullable=false)
private String servicesName;
@Column(name="ServicesDesc")
private String servicesDesc;
@Column(name="ServicesCode",nullable=false)
private String servicesCode;
@Column(name="ServicesCost",nullable=false)
private float servicesCost;
public long getServicesId() {
	return ServicesId;
}
public void setServicesId(long servicesId) {
	ServicesId = servicesId;
}
public String getServicesName() {
	return servicesName;
}
public void setServicesName(String servicesName) {
	this.servicesName = servicesName;
}
public String getServicesDesc() {
	return servicesDesc;
}
public void setServicesDesc(String servicesDesc) {
	this.servicesDesc = servicesDesc;
}
public String getServicesCode() {
	return servicesCode;
}
public void setServicesCode(String servicesCode) {
	this.servicesCode = servicesCode;
}
public float getServicesCost() {
	return servicesCost;
}
public void setServicesCost(float servicesCost) {
	this.servicesCost = servicesCost;
}
public boolean isServicesActive() {
	return servicesActive;
}
public void setServicesActive(boolean servicesActive) {
	this.servicesActive = servicesActive;
}
@Column(name="ServicesActive")
private boolean servicesActive;

@ManyToMany(mappedBy = "services")
private Set<User> user;

}
