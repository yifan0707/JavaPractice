package com.spring.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
/* @ComponentScan("com.spring.annotations") */
@PropertySource("classpath:sports.properties")
public class ApplicationConfiguration {
	
	
	//define the bean for the DatabaseService
	@Bean
	public FortuneService databaseService() {
		return new DatabaseService();
	}
	
	//define bean for the coding Coach and inject dependency
	@Bean
	public Coach codingCoach() {
		return new CodingCoach(databaseService());
	}
	
	
	
	
}
