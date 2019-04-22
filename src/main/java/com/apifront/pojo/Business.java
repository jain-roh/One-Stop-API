package com.apifront.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Business extends BasicDetails{

@Column(name="BusinessName",nullable=false)
private String name;

@OneToMany(mappedBy = "business")
private Set<API> api;
public Set<API> getApi() {
	return api;
}
public void setApi(Set<API> api) {
	this.api = api;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}





}
