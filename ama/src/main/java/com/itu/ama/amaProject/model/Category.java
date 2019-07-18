package com.itu.ama.amaProject.model;

import java.util.ArrayList;
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
@Table(name="CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Long id;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="category")
	@JsonIgnoreProperties(ignoreUnknown = true, 
    value = {"hibernateLazyInitializer", "handler", "created"}) 
	private List<Issue> issues;

	public Category() {
		
	}
	
	public Category(Long id, String categoryName, List<Issue> issues) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.issues = issues;
	}

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	
	/** Helper
	 * 
	 */
	public void addIssue(Issue issue) throws Exception {
		if(issues== null) {
			issues = new ArrayList<Issue>();
			issues.add(issue);
		}else {
			this.issues.add(issue);
		}
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", issues=" + issues + "]";
	}
	
	

}
