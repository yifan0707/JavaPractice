package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemo {
	public static void main(String[] args) {
		//get spring context based on xml file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		//get coach class from context
		ApexCoach coach = context.getBean("gameCoach", ApexCoach.class);
		
		System.out.println(coach.getFortuneService());
		
		context.close();
		
	
	}
}
