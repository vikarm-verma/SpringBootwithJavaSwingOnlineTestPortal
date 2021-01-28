package com.onlineassessment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.EmployeeRegistration;
import com.onlineassessment.entity.StudentRegistration;

public interface EmployeeRepository extends CrudRepository<EmployeeRegistration,Integer>{
	@Query("select s from EmployeeRegistration s where s.email=:email")
	public EmployeeRegistration findByEmail(@Param ("email")String email);
	
	

}
