package com.onlineassessment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.repository.StudentRepository;

public class StudentDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		StudentRegistration user = studentRepository.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("could not found user ");
		}
		CustomStudentDetails csd = new CustomStudentDetails(user);
		return csd;
	}

}
