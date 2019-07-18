package com.itu.ama.amaProject.model;

import com.itu.ama.amaProject.type.Day;

public class Availability {
	
	private Day day;


	private String startTime;

	private String endTime;
	
	
	public Availability(Day day, String startTime, String endTime) {
		this.day=day;
		this.startTime=startTime;
		this.endTime = endTime;
	}


	public Day getDay() {
		return day;
	}


	public String getStartTime() {
		return startTime;
	}


	public String getEndTime() {
		return endTime;
	}
	
	
	public void setDay(Day day) {
		this.day = day;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	

}
