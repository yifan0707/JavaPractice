package com.spring.annotations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class LuckyFortuneService implements FortuneService {
	List<String> fortunes;
	
	public LuckyFortuneService() {
		fortunes = new ArrayList<String>();
	}
	
	@Override
	public String getFortune() {
		Random random = new Random();
		int index = random.nextInt(fortunes.size());
		
		return fortunes.get(index);
	}
	
	//Post construct method
	@PostConstruct
	public void readFortunes() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("random.txt"));
			System.out.print(System.getProperty("user.dir"));
			System.out.println("Scanner added");
			
			while(scan.hasNextLine()) {
				fortunes.add(scan.nextLine());
			}
			scan.close();
		} catch(Exception e) {
			System.out.println("Scanning problem");
		}
	}
	
	//Pre destroy method
	@PreDestroy
	public void destroyMethod() {
		System.out.println("The destroy method has been called");
	}

}
