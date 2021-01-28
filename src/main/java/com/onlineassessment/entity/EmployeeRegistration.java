package com.onlineassessment.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator;

@Entity  
//defining class name as Table name  
@Table (name="employeeregistration")
public class EmployeeRegistration {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
  	@GenericGenerator(
        name = "emp_seq", 
        strategy = "com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator", 
        parameters = {
        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
        		@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "JUMPEID"),
        		@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
private String empId;
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
private boolean isActive;


public EmployeeRegistration() {
	super();
	// TODO Auto-generated constructor stub
}

public EmployeeRegistration(String empId, @NotBlank(message = "user name cannot be empty") String fullName,
		@NotBlank(message = "email must be there") @Email String email,
		@NotNull @Size(max = 100, min = 8, message = "password must be of at least 8 characters") String password,
		String date, String role,boolean isActive) {
	super();
	this.empId = empId;
	this.fullName = fullName;
	this.email = email;
	this.password = password;
	this.date = date;
	this.role = role;
	this.isActive = isActive;
	
}

public boolean getIsActive() {
	return isActive;
}





public void setIsActive(boolean isActive) {
	this.isActive = isActive;
}










public String getEmpId() {
	return empId;
}



public void setEmpId(String empId) {
	this.empId = empId;
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



public String getRole() {
	return role;
}



public void setRole(String role) {
	this.role = "ROLE_TA";
}





@Override
public String toString() {
	return "EmployeeRegistration [empId=" + empId + ", fullName=" + fullName + ", email=" + email + ", password="
			+ password + ", date=" + date + ", role=" + role + ", isActive=" + isActive + "]";
}







}
