package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.*;
import com.onlineassessment.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
 StudentRepository studentRepository;

public List<StudentRegistration> getAllStudents()
{
	List<StudentRegistration> list = new ArrayList<StudentRegistration>();
this.studentRepository.findAll().forEach(students->list.add(students));;
	return list;
}

public Optional<StudentRegistration> getStudentById(int id)
{

return studentRepository.findById(id);
	 
	}

public void addStudent(StudentRegistration stReg)
{
	 studentRepository.save(stReg);
	
}
public void deleteStudent(int id)
{
	this.studentRepository.deleteById(id);
}
public void updateStudent(StudentRegistration sr , int studentId)
{
	//sr.setId=id;
	this.studentRepository.save(sr);
}

public StudentRegistration findByEmail(String email) {
	return studentRepository.findByEmail(email);
}



}