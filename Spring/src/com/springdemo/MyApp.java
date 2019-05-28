package com.springdemo;
/**
 * Created in 28th/05/2019
 * @author Yifan Lu
 * 
 */
public class MyApp {

	public static void main(String[] args) {
		
		//create object
		Coach theCoach = new BaseballCoach();
		
		//use object
		System.out.println(theCoach.getDailyWorkOut());
	}

}
