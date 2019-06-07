package com.spring.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component("thatGameCoach")
/* @Scope("prototype") */
public class MobaCoach implements Coach{
	@Autowired
	@Qualifier("luckyFortuneService")
	FortuneService fortuneService;
	
	//create a default constructor
	public MobaCoach() {
		System.out.println("inside the default constructor");
	}
	
	//define the init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("At the start up constructor");
	}
	
	//define the destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("At the clean up method");
	}
	
	
	
	
	/*
	 * setter injection
	 */
	//creating a setter method
	//we can actually use any function names instead of just set[Property]
	/*
	public void crazyFunction(FortuneService service) {
		System.out.println("inside the setter method");
		this.fortuneService = service;
	}
	*/
	
	/*
	 * constructor injection 
	 */
	/*
	@Autowired
	public MobaCoach(FortuneService service) {
		this.fortuneService = service;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice farming skills!";
	}
	
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
