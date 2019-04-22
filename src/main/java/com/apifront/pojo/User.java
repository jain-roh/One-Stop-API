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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;

@Entity
public class User extends BasicDetails{

@Column(name="Name",nullable=false)
private String name;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

@ManyToMany(cascade= {CascadeType.PERSIST})
@JoinTable(
    name = "API_Users", 
    joinColumns = { @JoinColumn(name = "user_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "api_id") }
)
private Set<API> api=new HashSet<API>();

@ManyToMany(cascade = { CascadeType.ALL,CascadeType.REFRESH},fetch = FetchType.EAGER )
@JoinTable(
    name = "Service_Users", 
    joinColumns = { @JoinColumn(name = "user_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "service_id") }
)
private Set<Services> services=new HashSet();
public Set<API> getApi() {
	return api;
}
public void setApi(Set<API> api) {
	this.api = api;
}
public Set<Services> getServices() {
	return services;
}
public void setServices(Set<Services> services) {
	this.services = services;
}


}