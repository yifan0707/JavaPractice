package com.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
	public static void main(String[] args) {
		//read xml config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get bean from spring container
		Coach theCoach = context.getBean("thatGameCoach", MobaCoach.class);
		
		Coach secCoach = context.getBean("thatGameCoach", MobaCoach.class);
		
		//call method on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//check whether the objects are the same
		boolean result = (theCoach == secCoach);
		if(result) {
			System.out.println("The Coach and SecCoach are the Same");	
		} else {
			System.out.println("The Coach and SecCoach are not the Same");
		}
		
		//close context
		context.close();
	}
}
