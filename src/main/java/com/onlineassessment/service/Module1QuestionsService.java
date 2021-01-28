package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.Module1Questions;
import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.repository.Module1QuestionRepository;

@Service
public class Module1QuestionsService {
	@Autowired
 Module1QuestionRepository module1QuestionsRepository;

public List<Module1Questions> getAllQuestions()
{
	List<Module1Questions> list = new ArrayList<Module1Questions>();
this.module1QuestionsRepository.findAll().forEach(questions->list.add(questions));;
	return list;
}

public Module1Questions getQuestionById(int id)
{

return module1QuestionsRepository.findQuestionById(id);
}
public void addQuestion(Module1Questions stReg)
{
	 module1QuestionsRepository.save(stReg);	
}

public void deleteQuestion(int id)
{
	this.module1QuestionsRepository.deleteById(id);
}
public void updateQuestion(Module1Questions sr , int questionId)
{
	//sr.setId=id;
	this.module1QuestionsRepository.save(sr);
}
public Module1Questions findByQuestion(String question) {
	return module1QuestionsRepository.findByQuestion(question);
}

}
