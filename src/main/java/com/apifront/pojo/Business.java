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
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

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


@Transient
private MultipartFile photo;

private String imageName;

public String getImageName() {
	return imageName;
}
public void setImageName(String imageName) {
	this.imageName = imageName;
}
public String getName() {
	return name;
}
public MultipartFile getPhoto() {
	return photo;
}
public void setPhoto(MultipartFile photo) {
	this.photo = photo;
}
public void setName(String name) {
	this.name = name;
}





}
