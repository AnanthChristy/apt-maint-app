package com.itu.ama.amaProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.itu.ama.amaProject.type.ResidenceType;
import com.itu.ama.amaProject.type.UserType;

@Entity
@Table(name="OWNER")
public class Owner extends User {
	
	@Column(name="START_YEAR")
	private String startYear;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 14)
	private ResidenceType residenceType;
	
	public Owner() {
		
	}
	
	
	public Owner(Long id, UserType userType, String username, String emailId, HousingGroup housingGroup,
			String phoneNumber, String alternateNumber) {
		super(id, userType, username, emailId, housingGroup, phoneNumber, alternateNumber);
		this.setUserType(UserType.OWNER);
	}

	public Owner(String startYear, ResidenceType residenceType) {
		super();
		this.setUserType(UserType.OWNER);
		this.startYear = startYear;
		this.residenceType = residenceType;
	}







	public String getStartYear() {
		return startYear;
	}

	public ResidenceType getResidenceType() {
		return residenceType;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public void setResidenceType(ResidenceType residenceType) {
		this.residenceType = residenceType;
	}
	
	

}
