package com.itu.ama.amaProject.model;

import java.util.ArrayList;
import java.util.List;

public class DaysAvail {
	
	private List<Availability> daysAvail = new ArrayList<Availability>();

	public List<Availability> getDaysAvail() {
		return daysAvail;
	}

	public void setDaysAvail(List<Availability> daysAvail) {
		this.daysAvail = daysAvail;
	}

	@Override
	public String toString() {
		return "DaysAvail [daysAvail=" + daysAvail + "]";
	}
	
	
	
	

}
