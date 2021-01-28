package com.onlineassessment.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineassessment.entity.EmployeeRegistration;
import com.onlineassessment.entity.ScheduleExam;
import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.service.EmployeeService;
import com.onlineassessment.service.StudentService; 

@Controller

public class RegisterController {

	@Autowired
	private StudentService studentService;
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/ta/studentregistration")
	public String showRegistrationForm(Model model) {
		
		model.addAttribute("standardDate",new Date());
	//	model.addAttribute("studentregistration",new StudentRegistration());
		return "register";
	}
	
	@GetMapping("/admin/employeeregistration")
	public String showEmpRegistrationForm(Model model) {
		model.addAttribute("standardDate",new Date());
		return "employeeregistration";
	}

	@ModelAttribute("studentregistration")
	public StudentRegistration studentRegistration() {
		return new StudentRegistration();
	}
	
	@ModelAttribute("employeeregistration")
	public EmployeeRegistration employeeRegistration() {
		return new EmployeeRegistration();
	}

	@PostMapping("/ta/studentregistration")
	public String registerStudentAccount(
			@Valid @ModelAttribute("studentregistration") StudentRegistration studentRegistration, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println("ERROR " + result.toString());
			model.addAttribute("studentregistration", studentRegistration);
			return "register";
		}
		StudentRegistration studentExists = studentService.findByEmail(studentRegistration.getEmail());
		System.out.println(studentExists);
		if (studentExists != null) {
			// model.addAttribute("alreadyRegistered","user is already registered");
			return "redirect:/ta/studentregistration?alreadyRegistered";
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(studentRegistration.getPassword());
			studentRegistration.setPassword(encodedPassword);
			studentService.addStudent(studentRegistration);
			return "redirect:/ta/studentregistration?success";
		}
	}
	
	
	@PostMapping("/admin/empregistration")
	public String registerEmployeeAccount(
			@Valid @ModelAttribute("employeeregistration") EmployeeRegistration employeeRegistration, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println("ERROR " + result.toString());
			model.addAttribute("employeeRegistration", employeeRegistration);
			return "employeeregistration";
		}
		EmployeeRegistration employeeExists = employeeService.findByEmail(employeeRegistration.getEmail());
		System.out.println(employeeExists);
		if (employeeExists != null) {
			// model.addAttribute("alreadyRegistered","user is already registered");
			return "redirect:/registration?alreadyRegistered";
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(employeeRegistration.getPassword());
			employeeRegistration.setPassword(encodedPassword);
			employeeService.addEmployee(employeeRegistration);
			return "redirect:/registration?success";
		}
	}
	
}
