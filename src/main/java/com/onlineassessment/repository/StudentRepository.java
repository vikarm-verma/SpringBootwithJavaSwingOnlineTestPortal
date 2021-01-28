package com.onlineassessment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.StudentRegistration;

public interface StudentRepository extends CrudRepository<StudentRegistration,Integer>{
	@Query("select s from StudentRegistration s where s.email=:email")
	public StudentRegistration findByEmail(@Param ("email")String email);
	
//	@Query("select s.s_id from StudentRegistration s ")
//	public StudentRegistration getStudentId(@Param ("studentId")String studentId);
	
	
}
