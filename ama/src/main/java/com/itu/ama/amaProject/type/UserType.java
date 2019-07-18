package com.itu.ama.amaProject.type;


import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType{
	
	RESIDENT("Resident"),
		
	OWNER("Owner"),
	
	TECHNICIAN("Technician");
	
	private final String type; 

	UserType(String val){
		this.type = val;
	}
	
	@JsonValue
	public String toString() {
	    return String.valueOf(type);
	  }
	
	@JsonCreator
	public UserType fromValue(String strVal) {
		for(UserType userType:values()) {
			if(userType.type.equalsIgnoreCase(strVal)) {
				return userType;
			}
		}
		throw new IllegalArgumentException("Unknown enum type"+type+" ,Allowed values are "+Arrays.toString(values()));
	}

	
	
	

}
