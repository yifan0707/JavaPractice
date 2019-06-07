package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		//load the Spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		SwimCoach secCoach = context.getBean("secCoach", SwimCoach.class);
				
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkOut());
		System.out.println(secCoach.getDailyWorkOut());
		//call methods for fortune service
		System.out.println(theCoach.getDailyFortune());
		System.out.println(secCoach.getDailyFortune());
		
		System.out.println(secCoach.getEmail());
		System.out.println(secCoach.getName());
		
		//close the context
		context.close();
	}

}
