package com.itu.ama.amaProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.itu.ama.amaProject.type.WorkOrderStatus;
@Entity
@Table(name="WORK_ORDER")
public class WorkOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WORK_ORDER_ID")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", nullable = false)
	private Resident resident;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
	private Owner owner;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technician_id")
	private Technician technician;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id", nullable = false)
	private Issue issue;
	
	@Column(name="DATE_CREATED")
	private Date date = new Date();
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private WorkOrderStatus status;

	public WorkOrder() {
		
	}
	
	public WorkOrder(Long id, Resident resident, Owner owner, Technician technician, Category category, Issue issue,
			Date date, WorkOrderStatus status) {
		super();
		this.id = id;
		this.resident = resident;
		this.owner = owner;
		this.technician = technician;
		this.category = category;
		this.issue = issue;
		this.date = new Date();
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public Resident getResident() {
		return resident;
	}

	public Owner getOwner() {
		return owner;
	}

	public Technician getTechnician() {
		return technician;
	}

	public Category getCategory() {
		return category;
	}

	public Issue getIssue() {
		return issue;
	}

	public Date getDate() {
		return date;
	}

	public WorkOrderStatus getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public void setDate(Date date) {
		if(date==null) {
			this.date = new Date();
		}
		this.date = date;
	}

	public void setStatus(WorkOrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "WorkOrder [id=" + id + ", resident=" + resident + ", owner=" + owner + ", technician=" + technician
				+ ", category=" + category + ", issue=" + issue + ", date=" + date + ", status=" + status + "]";
	}
	
	
	

}
