package com.itu.ama.amaProject.type;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ResidenceType {
	
	inResidence("IN_RESIDENCE"),
	
	offResidence("OFF_RESIDENCE");
	
	private final String residenceType; 

	ResidenceType(String val){
		this.residenceType = val;
	}
	
	@JsonValue
	public String toString() {
	    return String.valueOf(residenceType);
	  }
	
	
	@JsonCreator
	public ResidenceType fromValue(String strVal) {
		for(ResidenceType resType:values()) {
			if(resType.residenceType.equalsIgnoreCase(strVal)) {
				return resType;
			}
		}
		throw new IllegalArgumentException("Unknown enum type"+strVal+" ,Allowed values are "+Arrays.toString(values()));
	}
	

}
