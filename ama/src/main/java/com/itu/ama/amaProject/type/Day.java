package com.itu.ama.amaProject.type;

import org.springframework.util.StringValueResolver;

public enum Day implements StringValueResolver{
	
	sun("Sunday"),
	
	sat("Saturday"),
	
	mon("Monday"),
	
	tue("Tuesday"),
	
	wed("Wednesday"),
	
	thu("Thur"),
	
	fri("Friday");
	
	private final String day;
	
	Day(String val){
		this.day = val;
	}
	
	@Override
	public String resolveStringValue(String strVal) {
		// TODO Auto-generated method stub
		return this.day;
	}
	

}
