package com.onlineassessment.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.onlineassessment.entity.EmployeeRegistration;

public class CustomEmployeeDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmployeeRegistration employeeRegistration;
	
	public CustomEmployeeDetails(EmployeeRegistration user) {
		// TODO Auto-generated constructor stub
		this.employeeRegistration=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority sga=new SimpleGrantedAuthority(employeeRegistration.getRole());
		
		return List.of(sga);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return employeeRegistration.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return employeeRegistration.getEmail();
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
