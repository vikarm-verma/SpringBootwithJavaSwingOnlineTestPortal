package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.StudentMT;
import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.repository.StudentMTRepository;

@Service
public class StudentMTService {

	@Autowired
	StudentMTRepository studentMTRepository;
	
//	public List<StudentRegistration> getAllStudents()
//	{
//		List<StudentRegistration> list = new ArrayList<StudentRegistration>();
//		studentMTRepository.getAllStudents().forEach(student->list.add(student));
//		return list;
//	}

	public List<StudentMT> getAllMTS() {
		List<StudentMT> list = new ArrayList<StudentMT>();
		this.studentMTRepository.findAll().forEach(mts -> list.add(mts));
		return list;
	}

	public StudentMT getMTByEmail(String id) {

		return studentMTRepository.findByEmail(id);
	}

	public void addMT(StudentMT stMT) {
		studentMTRepository.save(stMT);
	}

	public void deleteMT(String id) {
		this.studentMTRepository.deleteById(id);
	}

	public void updateMT(StudentMT sr, String mtId) {
		// sr.setId=id;
		this.studentMTRepository.save(sr);
	}
	
	public void update(Boolean active,String id)
	{
		this.studentMTRepository.update(active, id);
	}
}
