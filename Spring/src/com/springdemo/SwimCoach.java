package com.springdemo;

public class SwimCoach implements Coach{
	//define a private field for dependency
	private FortuneService fortuneService;
	private String email;
	private String name;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public SwimCoach() {
		System.out.println("Inside default constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public void setEmail(String email) {
		System.out.println("SwimCoach: inside the setEmail method");
		this.email = email;
	}
	
	public void setName(String name) {
		System.out.println("SwimCoach: inside the setName method");
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Practice breathing for 10 min";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getService();
	}
	
	
}
