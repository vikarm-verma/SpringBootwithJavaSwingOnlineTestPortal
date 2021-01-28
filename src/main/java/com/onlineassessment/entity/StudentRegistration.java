package com.onlineassessment.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator;
//mark class as an Entity   
@Entity  
//defining class name as Table name  
@Table (name="studentregistration")
public class StudentRegistration 
{
	
	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	  	@GenericGenerator(
	        name = "student_seq", 
	        strategy = "com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "JUMPSID"),
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })

private String sId;
@NotBlank(message="user name cannot be empty")
private String fullName;
@Column(unique=true)
@NotBlank(message="email must be there")
@Email
private String email;
@NotNull
@Size(max = 100, min = 8, message = "password must be of at least 8 characters")
private String password;
private String date;
private String role;

@Column(columnDefinition="tinyint(1) default 1")
private boolean active=true;

public StudentRegistration() {
	super();
	// TODO Auto-generated constructor stub
}

public StudentRegistration(String sId, @NotBlank(message = "user name cannot be empty") String fullName,
		@NotBlank(message = "email must be there") @Email String email,
		@NotNull @Size(max = 100, min = 8, message = "password must be of at least 8 characters") String password,
		String date, String role, boolean active) {
	super();
	this.sId = sId;
	this.fullName = fullName;
	this.email = email;
	this.password = password;
	this.date = date;
	this.role = role;
	this.active = active;
}

public String getsId() {
	return sId;
}
public void setsId(String sId) {
	this.sId = sId;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = "ROLE_STUDENT";
}
public void setPassword(String password) {
	this.password = password;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	  
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
    this.date= formatter.format(new Date());  
}





public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

@Override
public String toString() {
	return "StudentRegistration [sId=" + sId + ", fullName=" + fullName + ", email=" + email + ", password=" + password
			+ ", date=" + date + ", role=" + role + ", isActive=" + active + "]";
}

}
