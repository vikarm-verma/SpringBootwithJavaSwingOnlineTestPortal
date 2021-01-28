package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.PracticeQuestions;
import com.onlineassessment.repository.PracticeQuestionsRepository;

@Service
public class PracticeQuestionsService {

	@Autowired
 PracticeQuestionsRepository practiceQuestionsRepository;

public List<PracticeQuestions> getAllQuestions()
{
	List<PracticeQuestions> list = new ArrayList<PracticeQuestions>();
this.practiceQuestionsRepository.findAll().forEach(questions->list.add(questions));;
	return list;
}

public PracticeQuestions getQuestionById(int id)
{

return practiceQuestionsRepository.findQuestionById(id);
	}



public void addQuestion(PracticeQuestions stReg)
{
	 practiceQuestionsRepository.save(stReg);	
}

public void deleteQuestion(int id)
{
	this.practiceQuestionsRepository.deleteById(id);
}
public void updateQuestion(PracticeQuestions sr , int questionId)
{
	//sr.setId=id;
	this.practiceQuestionsRepository.save(sr);
}
public PracticeQuestions findByQuestion(String question) {
	return practiceQuestionsRepository.findByQuestion(question);
}

	
}
