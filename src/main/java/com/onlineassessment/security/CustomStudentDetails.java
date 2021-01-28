package com.onlineassessment.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.onlineassessment.entity.StudentRegistration;

public class CustomStudentDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private StudentRegistration studentRegistration;
	
	public CustomStudentDetails() {
		// TODO Auto-generated constructor stub
	//	this.studentRegistration=user;
	}
	
	public CustomStudentDetails(StudentRegistration user) {
		// TODO Auto-generated constructor stub
		this.studentRegistration=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority sga=new SimpleGrantedAuthority(studentRegistration.getRole());
		
		return List.of(sga);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return studentRegistration.getPassword();
	}

	public String getStudentId() {
		// TODO Auto-generated method stub
		return studentRegistration.getsId();
	}

	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return studentRegistration.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
