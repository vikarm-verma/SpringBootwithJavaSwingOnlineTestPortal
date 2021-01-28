package com.onlineassessment.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.StudentMT;

public interface StudentMTRepository extends CrudRepository<StudentMT,String> {
	@Query("select s from StudentMT s where s.email=:email")
	public StudentMT findByEmail(@Param ("email")String email);
	
	
	//@Query("UPDATE StudentMT SET mtActive = ? WHERE id = ?")
	
//	@Query("select s from StudentRegistration s")
//	public List<StudentRegistration> getAllStudents();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE StudentMT SET mtActive= :mtActive where schmtid=:schmtid")
	public void update(@Param("mtActive") Boolean mtActive, @Param("schmtid") String schmtid); 
	
	
	
}
