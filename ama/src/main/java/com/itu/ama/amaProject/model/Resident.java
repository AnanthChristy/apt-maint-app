package com.itu.ama.amaProject.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itu.ama.amaProject.type.UserType;

@Entity
@Table(name="RESIDENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resident extends User {
	
	@Column(name="DOOR_NO")
	private int doorNo;
	
	public Resident() {
		
	}

	

	public Resident(int doorNo) {
		super();
		this.setUserType(UserType.RESIDENT);
		this.doorNo = doorNo;
	}



	public Resident(Long id,String username, String emailId, HousingGroup houseGroup, int doorNo, String phoneNumber, String alternateNumber) {
		super(id, UserType.RESIDENT, username, emailId, houseGroup, phoneNumber, alternateNumber);
		this.doorNo = doorNo;
	}

	public int getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	
	
	
	
	
	
	

}
