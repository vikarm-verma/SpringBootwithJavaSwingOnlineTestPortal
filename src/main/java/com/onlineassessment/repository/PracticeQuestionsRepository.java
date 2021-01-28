package com.onlineassessment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.Module1Questions;
import com.onlineassessment.entity.PracticeQuestions;

public interface PracticeQuestionsRepository extends CrudRepository<PracticeQuestions,Integer> {
	@Query("select s from PracticeQuestions s where s.question=:question")
	public PracticeQuestions findByQuestion(@Param ("question")String question);
	
	@Query("select s from PracticeQuestions s where s.qId=:qId")
	public PracticeQuestions findQuestionById(@Param ("qId")int qId); 
}
