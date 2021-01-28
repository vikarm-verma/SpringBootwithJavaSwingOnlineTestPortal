package com.onlineassessment.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.security.CustomStudentDetails;
import com.onlineassessment.service.StudentService;
import com.onlineassessment.service.ViewModuleTestResultService;
import com.onlineassessment.service.ViewPracticeTestResultService;

@Controller
public class ResultController {

	@Autowired
	private ViewPracticeTestResultService viewPracticeTestResultService;
	
	@Autowired
	private ViewModuleTestResultService viewModuleTestResultService;

	@Autowired
	private StudentService studentService;
	
//	@Autowired
//	private StudentService studentService;

	@GetMapping("/ta/viewpracticetestresult")
	public String viewPracticeTestResult(Model model) {

		model.addAttribute("module1practiceResults", viewPracticeTestResultService.getAllResults());
		return "viewpracticetestresult";
	}

	@GetMapping("/ta/viewmoduletestresult")
	public String viewModuleTestResult(Model model) {
		model.addAttribute("module1practiceResults", viewModuleTestResultService.getAllResults());
		return "viewmoduletestresult";
	}

	@GetMapping("/student/viewpracticetestresult")
	public String viewPracticeTestResultForStudent(HttpServletRequest request, Model model) {
		Principal principal = request.getUserPrincipal();
		StudentRegistration sr = studentService.findByEmail(principal.getName());
		System.out.println("email is " + sr.getsId());
		model.addAttribute("module1practiceResults", viewPracticeTestResultService.getResultByStudentId(sr.getsId()));
		System.out.println("before reaching to template ");
		return "viewpracticetestresult";
	}

	@GetMapping("/student/viewmoduletestresult")
	public String viewModuleTestResultForStudent(HttpServletRequest request, Model model) {
	//	model.addAttribute("module1practiceResults", viewPracticeTestResultService.getAllResults());
		
		Principal principal = request.getUserPrincipal();
		StudentRegistration sr = studentService.findByEmail(principal.getName());
		System.out.println("email is " + sr.getsId());
		model.addAttribute("module1practiceResults", viewModuleTestResultService.getResultByStudentId(sr.getsId()));
		System.out.println("before reaching to template ");
	
		return "viewmoduletestresult";
	}

	

}
