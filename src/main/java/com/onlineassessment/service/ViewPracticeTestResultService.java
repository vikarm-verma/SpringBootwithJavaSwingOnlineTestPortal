package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.PracticeTestResult;
import com.onlineassessment.entity.PracticeTestResult;
import com.onlineassessment.repository.ViewPracticeTestResultRepository;
import com.onlineassessment.repository.ViewPracticeTestResultRepository;

@Service
public class ViewPracticeTestResultService  {

	@Autowired
 ViewPracticeTestResultRepository viewPracticeTestResultRepository;

public List<PracticeTestResult> getAllResults()
{
	List<PracticeTestResult> list = new ArrayList<PracticeTestResult>();
this.viewPracticeTestResultRepository.findAll().forEach(record->list.add(record));;
	return list;
}

public List<PracticeTestResult> getResultByStudentId(String studentId)
{
	List<PracticeTestResult> list = new ArrayList<PracticeTestResult>();
	//this.viewPracticeTestResultRepository.findPracticeResultId(studentId);//.iterator();
	this.viewPracticeTestResultRepository.findPracticeResultId(studentId).forEach(a->list.add(a));
	System.out.println("list is "+list);
	return list;
}

public void addQuestion(PracticeTestResult stReg)
{
	
}

public void deleteQuestion(int id)
{

}
public void updateQuestion(PracticeTestResult sr , int questionId)
{
	//sr.setId=id;
//	this.viewPracticeTestResultRepository.save(sr);
}
public PracticeTestResult findByQuestion(String question) {
	return null;
}

}
