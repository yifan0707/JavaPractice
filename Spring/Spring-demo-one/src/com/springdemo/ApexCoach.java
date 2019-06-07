package com.springdemo;

public class ApexCoach implements Coach {
	private FortuneService service;
	
	public void setService(FortuneService service) {
		this.service = service;
	}
	
	public String getFortuneService() {
		return service.getService();
	}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
