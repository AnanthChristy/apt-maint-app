package com.itu.ama.amaProject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.itu.ama.amaProject.type.UserType;

@Entity
@Table(name="TECHNICIAN")
public class Technician extends User{
	
	public Technician() {
		
	}
	
	@Column(name="EXPERTISE")
	private String expertise;

	public Technician(Long id, String username, String emailId, HousingGroup houseGroup, String phoneNumber, String alternateNumber) {
		super(id, UserType.TECHNICIAN,username, emailId, houseGroup, phoneNumber, alternateNumber);
	}

	public Technician(Long id, String username, String emailId, HousingGroup houseGroup, String phoneNumber, String alternateNumber,
			String expertise) {
		super(id, UserType.TECHNICIAN,username, emailId, houseGroup, phoneNumber, alternateNumber);
		this.expertise = expertise;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	
	

}
