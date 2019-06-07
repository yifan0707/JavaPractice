package com.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
	public static void main(String[] args) {
		//read Java class config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		//get bean from spring container
		Coach theCoach = context.getBean("thatGameCoach", MobaCoach.class);
		
		theCoach.getDailyFortune();
		
		//close context
		context.close();
	}
}
