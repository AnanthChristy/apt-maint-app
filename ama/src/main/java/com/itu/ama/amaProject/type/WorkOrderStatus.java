package com.itu.ama.amaProject.type;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum WorkOrderStatus {
	
	OPEN("OPEN"),
	
	ACCEPTED("ACCEPTED"),
	
	IN_PROGRESS("IN_PROGRESS"),
	
	RESOLVED("RESOLVED"),
	
	DEFERRED("DEFERRED");
	
	private final String status;
	
	WorkOrderStatus(String val){
		status = val;
	}
	
	public String resolveStringValue(String strVal) {
		// TODO Auto-generated method stub
		return this.status;
	}
	
	@JsonCreator
	public static WorkOrderStatus fromValue(String strVal) {
		for(WorkOrderStatus workOrderStatus:values()) {
			if(workOrderStatus.status.equalsIgnoreCase(strVal)) {
				return workOrderStatus;
			}
		}
		throw new IllegalArgumentException("Unknown enum type"+strVal+" ,Allowed values are "+Arrays.toString(values()));
	}
	

}
