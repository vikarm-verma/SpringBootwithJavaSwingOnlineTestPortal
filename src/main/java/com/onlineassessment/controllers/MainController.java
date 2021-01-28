package com.onlineassessment.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	@GetMapping("/")
	public String homePage()
	{
		return "landingpage";
	}

	@GetMapping("/signin")
	public String loginPage()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "loginPage";
        }
 
        return "redirect:/";
	}
	@GetMapping("/commondashboard")
	public String studentDashboard()
	{
		return "commondashboard";
	}
	
//	 @GetMapping("/signin")
//	    public String showLoginForm(Model model) {
//	         
//	        
	//    }
	
	
//	@GetMapping("/employeeregistration")
//	public String employeeRegistration()
//	{
//		return "employeeregistration";
//	}
}
