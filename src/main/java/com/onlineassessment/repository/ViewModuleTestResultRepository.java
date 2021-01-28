package com.onlineassessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.ModuleTestResult;
import com.onlineassessment.entity.ModuleTestResult;

public interface ViewModuleTestResultRepository extends CrudRepository<ModuleTestResult, String> {
	@Query("select s from ModuleTestResult s where s.studentId=:studentId")
	public List<ModuleTestResult> findModuleResultId(@Param ("studentId")String studentId);
}
