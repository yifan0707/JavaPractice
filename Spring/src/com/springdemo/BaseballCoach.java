package com.springdemo;

public class BaseballCoach implements Coach{
	public String getDailyWorkOut() {
		return "Spend 30 minutes on running practice.";
	}
	
	@Override
	public String getDailyFortune() {
		return "";
	}
}
