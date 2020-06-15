package com.project2.cms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//import lombok.Data;

@Entity
@Table(schema="project2", name = "writers")

public class Writer implements Serializable {

	private static final long serialVersionUID = 172860970553622844L;
@Id
  @Column(name = "writerid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer writerid;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "firstname")
  private String firstname;
  @Column(name = "lastname")
  private String lastname;
  @Column(name = "email")
  private String email;
  @Column(name = "phonenumber")
  private String phone;
  @Column(name = "permissions")
  private Integer permissions;

  public Writer() {
	  
  }
  

public Writer(Integer writerid, String username, String password, String firstname, String lastname, String email,
		String phone, Integer permission) {
	super();
	this.writerid = writerid;
	this.username = username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.phone = phone;
	this.permissions = permission;
}


public Integer getWriterid() {
	return writerid;
}


public void setWriterid(Integer writerid) {
	this.writerid = writerid;
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


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public Integer getPermission() {
	return permissions;
}


public void setPermission(Integer permission) {
	this.permissions = permission;
}


@Override
public String toString() {
	return "Writer [writerid=" + writerid + ", username=" + username + ", password=" + password + ", firstname="
			+ firstname + ", lastname=" + lastname + ", email=" + email + ", phone=" + phone + ", permission="
			+ permissions + "]";
}
  
  
}
