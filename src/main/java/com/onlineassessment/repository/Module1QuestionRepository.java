package com.onlineassessment.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.Module1Questions;

public interface Module1QuestionRepository extends CrudRepository<Module1Questions,Integer> {
	@Query("select s from Module1Questions s where s.question=:question")
	public Module1Questions findByQuestion(@Param ("question")String question);
	
	@Query("select s from Module1Questions s where s.qId=:qId")
	public Module1Questions findQuestionById(@Param ("qId")int qId);
}
