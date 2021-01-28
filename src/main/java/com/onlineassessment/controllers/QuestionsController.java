package com.onlineassessment.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineassessment.entity.EmployeeRegistration;
import com.onlineassessment.entity.Module1Questions;
import com.onlineassessment.entity.PracticeQuestions;
import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.service.EmployeeService;
import com.onlineassessment.service.Module1QuestionsService;
import com.onlineassessment.service.PracticeQuestionsService;

@Controller
public class QuestionsController {

	@Autowired
	private Module1QuestionsService module1QuestionService;

	@Autowired
	private PracticeQuestionsService practiceQuestionService;

	@GetMapping("/ta/viewmodule1questions")
	public String viewModuel1Questions(Model model) {
		model.addAttribute("module1questions", module1QuestionService.getAllQuestions());
		return "viewmodule1questions";
	}

	@GetMapping("/ta/addmodule1questions")
	public String moduel1Questions(Model model) {
		model.addAttribute("add", true);
		return "addmodule1questions";
	}

	@ModelAttribute("module1questions")
	public Module1Questions module1Questions() {
		return new Module1Questions();
	}

	@PostMapping("/ta/addmodule1questions")
	public String addModule1Question(@Valid @ModelAttribute("module1questions") Module1Questions module1Questions,
			BindingResult result, Model model, @RequestParam(required=false) String optradio) {
		if (result.hasErrors()) {
			System.out.println("ERROR " + result.toString());
			model.addAttribute("module1questions", module1Questions);
			model.addAttribute("add",true);
			return "addmodule1questions";
		}
		if(optradio==null)
		{
			model.addAttribute("module1questions", module1Questions);
			model.addAttribute("add",true);
			
			return "redirect:/ta/addmodule1questions?radioCheck";
			
		}
		Module1Questions questionExists = module1QuestionService.findByQuestion(module1Questions.getQuestion());
		System.out.println(questionExists);
		if (questionExists != null) {
			// model.addAttribute("alreadyRegistered","user is already registered");
			model.addAttribute("add",true);
			return "redirect:/ta/addmodule1questions?alreadyAdded";
		}
		// Integer.parseInt(optradio);
		module1Questions.setAnswer(Integer.parseInt(optradio));
		module1QuestionService.addQuestion(module1Questions);
		model.addAttribute("add", true);
		System.out.println(module1Questions + "answer is " + optradio);
		return "redirect:/ta/addmodule1questions?success";

	}

	@GetMapping(value = { "/ta/module1questions/{questionId}/edit" })
	public String showEditContact(Model model, @PathVariable int questionId,
			@ModelAttribute("module1questions") Module1Questions module1Questions) {
		module1Questions = module1QuestionService.getQuestionById(questionId);
		module1Questions.setqId(questionId);
		model.addAttribute("add", false);
		model.addAttribute("module1questions", module1Questions);
		System.out.println("in edit" + questionId);
		return "addmodule1questions";

	}

	@PostMapping(value = { "/ta/module1questions/{questionId}/edit" })
	public String updateQuestion(Model model, @PathVariable int questionId,
			@Valid @ModelAttribute("module1questions") Module1Questions module1Questions, BindingResult result,@RequestParam(required=false) String optradio) {
		try {
			if (result.hasErrors()) {
				System.out.println("ERROR " + result.toString()); 
				module1Questions.setqId(questionId);
				model.addAttribute("module1questions", module1Questions);
				model.addAttribute("add", false);
				return "addmodule1questions";
			} 
			if(optradio==null)
			{
				model.addAttribute("module1questions", module1Questions);
				model.addAttribute("add",true);
				
				return "redirect:/ta/addmodule1questions?radioCheck";
				
			}
			module1Questions.setqId(questionId);
			module1Questions.setAnswer(Integer.parseInt(optradio));
			module1QuestionService.updateQuestion(module1Questions, questionId);
			model.addAttribute("module1questions", module1QuestionService.getAllQuestions());
			return "viewmodule1questions";
			// return "viewmodule1questions";
			}
			catch (Exception ex) {
			// log exception first,
			// then show error
			String errorMessage = ex.getMessage();
			// logger.error(errorMessage);
			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("add", false);
			return "addmodule1questions";
		}
	}

	// @DeleteMapping("/ta/module1questions/{questionId}/delete")
	@GetMapping(value = "/ta/module1questions/{questionId}/delete")
	public String deleteQuestion(Model model, @PathVariable int questionId,
			@Valid @ModelAttribute("module1questions") Module1Questions module1Questions, BindingResult result) {

		try {
			module1QuestionService.deleteQuestion(questionId);
			System.out.println("question deleted" + questionId);
			model.addAttribute("module1questions", module1QuestionService.getAllQuestions());
			return "viewmodule1questions";
		} catch (Exception e) {
			model.addAttribute("module1questions", module1QuestionService.getAllQuestions());
			return "viewmodule1questions";
		}
	}

//	Practice questions sections

	@GetMapping("/ta/viewpracticequestions")
	public String viewpracticeQuestions(Model model) {
		model.addAttribute("practicequestions", practiceQuestionService.getAllQuestions());
		return "viewpracticequestions";
	}

	@GetMapping("/ta/addpracticequestions")
	public String practiceQuestions(Model model) {
		model.addAttribute("add", true);
		return "addpracticequestions";
	}

	@ModelAttribute("practicequestions")
	public PracticeQuestions practiceQuestions() {
		return new PracticeQuestions();
	}

	@PostMapping("/ta/addpracticequestions")
	public String addPracticeQuestion(@Valid @ModelAttribute("practicequestions") PracticeQuestions practiceQuestions,
			BindingResult result, Model model, @RequestParam(required=false) String optradio) {
		if (result.hasErrors()) {
			System.out.println("ERROR " + result.toString());
			model.addAttribute("practicequestions", practiceQuestions);
			model.addAttribute("add",true);
			return "addpracticequestions";
		}

		PracticeQuestions questionExists = practiceQuestionService.findByQuestion(practiceQuestions.getQuestion());
		System.out.println(questionExists);
		if (questionExists != null) {
			// model.addAttribute("alreadyRegistered","user is already registered");
			model.addAttribute("add",true);
			return "redirect:/ta/addpracticequestions?alreadyAdded";
		}
		if(optradio==null)
		{
			model.addAttribute("practicequestions", practiceQuestions);
			model.addAttribute("add",true);
			
			return "redirect:/ta/addpracticequestions?radioCheck";
			
		}
		// Integer.parseInt(optradio);
		practiceQuestions.setAns(Integer.parseInt(optradio));
		practiceQuestionService.addQuestion(practiceQuestions);
		model.addAttribute("add", true);
		System.out.println(practiceQuestions + "answer is " + optradio);
		return "redirect:/ta/addpracticequestions?success";

	}
	@GetMapping(value = { "/ta/practicequestions/{questionId}/edit" })
	public String showEditContact(Model model, @PathVariable int questionId,
			@ModelAttribute("practicequestions") PracticeQuestions practiceQuestions) {
		practiceQuestions = practiceQuestionService.getQuestionById(questionId);
		model.addAttribute("add", false);
		model.addAttribute("practicequestions", practiceQuestions);
		System.out.println("in edit" + questionId);
		return "addpracticequestions";

	}

	@PostMapping(value = { "/ta/practicequestions/{questionId}/edit" })
	public String updateQuestion(Model model, @PathVariable int questionId,
			@Valid @ModelAttribute("practicequestions") PracticeQuestions practiceQuestions, BindingResult result,@RequestParam(required=false) String optradio) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("add", false);
				System.out.println("ERROR " + result.toString());
				practiceQuestions.setqId(questionId);
				model.addAttribute("practicequestions", practiceQuestions);
				return "addpracticequestions";
			}
			if(optradio==null)
			{
				model.addAttribute("practicequestions", practiceQuestions);
				model.addAttribute("add",true);
				
				return "redirect:/ta/addpracticequestions?radioCheck";
				
			}
			practiceQuestions.setAns(Integer.parseInt(optradio));
			practiceQuestions.setqId(questionId);
			practiceQuestionService.updateQuestion(practiceQuestions, questionId);

			// return "redirect:/contacts/" + String.valueOf(contact.getId());
			model.addAttribute("practicequestions", practiceQuestionService.getAllQuestions());
			return "viewpracticequestions";
			// return "viewmodule1questions";
		} catch (Exception ex) {
			// log exception first,
			// then show error
			String errorMessage = ex.getMessage();
			// logger.error(errorMessage);
			model.addAttribute("errorMessage", errorMessage);

			model.addAttribute("add", false);
			return "addpracticequestions";
		}
	}

	// @DeleteMapping("/ta/module1questions/{questionId}/delete")
	@GetMapping(value = "/ta/practicequestions/{questionId}/delete")
	public String deleteQuestion(Model model, @PathVariable int questionId,
			@Valid @ModelAttribute("practicequestions") PracticeQuestions practiceQuestions, BindingResult result) {

		try {
			practiceQuestionService.deleteQuestion(questionId);
			System.out.println("question deleted" + questionId);
			model.addAttribute("practicequestions", practiceQuestionService.getAllQuestions());
			return "viewpracticequestions";
		} catch (Exception e) {
			model.addAttribute("practicequestions", practiceQuestionService.getAllQuestions());
			return "viewpracticequestions";
		} 
	}
}
