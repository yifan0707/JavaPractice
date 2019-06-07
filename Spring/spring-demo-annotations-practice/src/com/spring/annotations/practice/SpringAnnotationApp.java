package com.spring.annotations.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationApp {
	public static void main(String[] args) {
		//get spring context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
		//retrieve bean from spring container
		Coach theCoach = context.getBean("badmintonCoach", BadmintonCoach.class);
		
		//Make use of the class
		System.out.println(theCoach.getDaliyWorkout());

		System.out.println(theCoach.getFortune());
		
		//close context
		context.close();
	}
}
