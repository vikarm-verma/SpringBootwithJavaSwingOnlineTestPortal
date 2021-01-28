package com.onlineassessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.Module1Questions;
import com.onlineassessment.entity.PracticeTestResult;

public interface ViewPracticeTestResultRepository extends CrudRepository<PracticeTestResult,String> {
	@Query("select s from PracticeTestResult s where s.studentId=:studentId")
	public List<PracticeTestResult> findPracticeResultId(@Param ("studentId")String studentId);
}
