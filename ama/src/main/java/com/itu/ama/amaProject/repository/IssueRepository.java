package com.itu.ama.amaProject.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itu.ama.amaProject.model.Issue;

public interface IssueRepository extends JpaRepository<Issue,Long>{

	@Query(value="SELECT * FROM ISSUE WHERE CATEGORY_ID=?1", nativeQuery = true)
	public Collection<Issue> getAllIssueByCategory(Long categoryId);
	
}
