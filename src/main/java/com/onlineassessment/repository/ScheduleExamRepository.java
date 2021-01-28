package com.onlineassessment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.ScheduleExam;
import com.onlineassessment.entity.StudentRegistration;

public interface ScheduleExamRepository extends CrudRepository<ScheduleExam,String> {
	@Query("select s from ScheduleExam s where s.examId=:examId")
	public ScheduleExam findByExamId(@Param ("examId")String examId);
}
