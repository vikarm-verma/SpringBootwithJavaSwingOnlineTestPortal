package com.onlineassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages= "com")
//@ComponentScan({"com.onlineassessment"})
@EnableScheduling
public class OnlineAssessmentApplication {
	public static void main(String[] args) { 
		SpringApplication.run(OnlineAssessmentApplication.class, args);
	}
}
 