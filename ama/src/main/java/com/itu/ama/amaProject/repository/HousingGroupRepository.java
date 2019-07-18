package com.itu.ama.amaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itu.ama.amaProject.model.HousingGroup;

public interface HousingGroupRepository extends JpaRepository<HousingGroup,Long> {
	
	
	List<HousingGroup> findByGroupName(String name);

}
