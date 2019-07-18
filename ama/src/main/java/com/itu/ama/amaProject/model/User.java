package com.itu.ama.amaProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.itu.ama.amaProject.type.UserType;

@Entity
@Table(name="USER")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="USER_ID")
	private Long id;
	
	@Enumerated(EnumType.STRING)
    @Column(length = 10)
	private UserType userType;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
	private HousingGroup housingGroup;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="alternate_number")
	private String alternateNumber;
	
	public User() {
		
	}

	public User(Long id, UserType userType, String username, String emailId, HousingGroup housingGroup,
			String phoneNumber, String alternateNumber) {
		super();
		this.id = id;
		this.userType = userType;
		this.username = username;
		this.emailId = emailId;
		this.housingGroup = housingGroup;
		this.phoneNumber = phoneNumber;
		this.alternateNumber = alternateNumber;
	}



	public Long getId() {
		return id;
	}

	public UserType getUserType() {
		return userType;
	}

	public HousingGroup getHousingGroup() {
		return housingGroup;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setHousingGroup(HousingGroup houseGroup) {
		this.housingGroup = houseGroup;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userType=" + userType + ", houseGroup=" + housingGroup + ", phoneNumber="
				+ phoneNumber + ", alternateNumber=" + alternateNumber + "]";
	}
	

}
