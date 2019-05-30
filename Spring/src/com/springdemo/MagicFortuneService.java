package com.springdemo;
import java.util.Random;

public class MagicFortuneService implements FortuneService{
	String fortuneArray[] = {"Gold Helmet", "Gold Armor", "Gold Backpack"};
	
	@Override
	public String getService() {
		Random random = new Random();
		switch(random.nextInt(3)) {
			case 0:
				return fortuneArray[0];
			case 1:
				return fortuneArray[1];
			case 2:
				return fortuneArray[2];
			default:
				return null;
		}
	}
	

}
