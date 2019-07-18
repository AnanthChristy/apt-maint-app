package com.itu.ama.amaProject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="HOUSING_GROUP")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HousingGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GROUP_ID")
	private Long id;
	
	@Column(name="GROUP_NAME")
	private String groupName;
	
	@Column(name="GROUP_ADDRESS")
	private String address;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="housingGroup")
	private List<User> user;
	
	public HousingGroup() {
		
	}

	public HousingGroup(Long id, String name, String address) {
		super();
		this.id = id;
		this.groupName = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return groupName;
	}

	public String getAddress() {
		return address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.groupName = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
