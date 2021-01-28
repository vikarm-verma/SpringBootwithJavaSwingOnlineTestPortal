
package com.onlineassessment.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;

import com.onlineassessment.service.StudentService;
  


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean 
	public UserDetailsService getStudentService()
	{
		return new StudentDetailsServiceImpl();
	}
	
	
	@Bean 
	public UserDetailsService getEmployeeService()
	{
		return new EmployeeDetailServiceImpl();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public DaoAuthenticationProvider authencationProvider()
	{
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setUserDetailsService(getStudentService());
		dap.setPasswordEncoder(passwordEncoder());
		
		return dap;
		
	}

	@Bean
	public DaoAuthenticationProvider authencationProvider1()
	{
		DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
		dap.setUserDetailsService(getEmployeeService());
		dap.setPasswordEncoder(passwordEncoder());
		
		return dap;
		
	}



	
	//configure method

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//cause we are using database authentication ,taking password from db and email too
		auth.authenticationProvider(authencationProvider());
		auth.authenticationProvider(authencationProvider1());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//the request coming from admin user can be used by those who has role "ROLE_ADMIN"
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/employee/**").hasRole("EMPLOYEE")
		.antMatchers("/student/**").hasRole("STUDENT")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/ta/**").hasRole("TA")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin().loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/commondashboard")
		.and()
		.logout()
		.logoutSuccessUrl("/")
		.addLogoutHandler(new HeaderWriterLogoutHandler(
	            new ClearSiteDataHeaderWriter(
	              ClearSiteDataHeaderWriter.Directive.CACHE,
	              ClearSiteDataHeaderWriter.Directive.COOKIES,
	              ClearSiteDataHeaderWriter.Directive.STORAGE)))
		.and().csrf().disable()
		.cors().disable();
	}
	
	
	
}