package com.spring.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBeanConfigDemoApp {
	public static void main(String[] args) {
		//read configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		//retrieve bean from spring container
		CodingCoach codingCoach = context.getBean("codingCoach", CodingCoach.class);
		
		//make use of the class
		System.out.println(codingCoach.getDailyFortune());
		System.out.println(codingCoach.getDailyWorkout());
		
		System.out.println("Property value Email: " + codingCoach.getEmail());
		System.out.println("Property value Team: " + codingCoach.getTeam());
		
		//close context
		context.close();
	}
	

	
}
