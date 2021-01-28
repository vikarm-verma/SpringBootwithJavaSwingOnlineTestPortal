package com.onlineassessment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.onlineassessment.entity.EmployeeRegistration;
import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.repository.EmployeeRepository;

public class EmployeeDetailServiceImpl implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		EmployeeRegistration user = employeeRepository.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("could not found user ");
		}
		CustomEmployeeDetails ced = new CustomEmployeeDetails(user);
		return ced;
	}

}