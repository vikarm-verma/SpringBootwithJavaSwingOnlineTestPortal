package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.ModuleTestResult;
import com.onlineassessment.entity.ModuleTestResult;
import com.onlineassessment.repository.ViewModuleTestResultRepository;
import com.onlineassessment.repository.ViewModuleTestResultRepository;

@Service
public class ViewModuleTestResultService 
{
	
	@Autowired
	 ViewModuleTestResultRepository viewModuleTestResultRepository;

	public List<ModuleTestResult> getAllResults()
	{
		List<ModuleTestResult> list = new ArrayList<ModuleTestResult>();
	this.viewModuleTestResultRepository.findAll().forEach(record->list.add(record));;
		return list;
	}

	public List<ModuleTestResult> getResultByStudentId(String studentId)
	{
		List<ModuleTestResult> list = new ArrayList<ModuleTestResult>();
		//this.viewModuleTestResultRepository.findModuleResultId(studentId);//.iterator();
		this.viewModuleTestResultRepository.findModuleResultId(studentId).forEach(a->list.add(a));
		System.out.println("list is "+list);
		return list;
	}

	public void addQuestion(ModuleTestResult stReg)
	{
		
	}

	public void deleteQuestion(int id)
	{

	}
	public void updateQuestion(ModuleTestResult sr , int questionId)
	{
		//sr.setId=id;
//		this.viewModuleTestResultRepository.save(sr);
	}
	public ModuleTestResult findByQuestion(String question) {
		return null;
	}


}
