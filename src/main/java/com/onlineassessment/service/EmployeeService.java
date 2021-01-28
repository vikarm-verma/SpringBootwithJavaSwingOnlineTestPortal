package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.EmployeeRegistration;

import com.onlineassessment.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeRegistration> getAllEmployees() {
		List<EmployeeRegistration> list = new ArrayList<EmployeeRegistration>();
		this.employeeRepository.findAll().forEach(employees -> list.add(employees));
		return list;
	}

	public Optional<EmployeeRegistration> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	public void addEmployee(EmployeeRegistration stReg) {
		employeeRepository.save(stReg);

	}

	public void deleteStudent(int id) {
		this.employeeRepository.deleteById(id);
	}

	public void updateStudent(EmployeeRegistration sr, int empId) {
		// sr.setId=id;
		this.employeeRepository.save(sr);
	}

	public EmployeeRegistration findByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}
}
