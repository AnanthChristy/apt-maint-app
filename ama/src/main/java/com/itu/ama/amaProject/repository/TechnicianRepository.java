package com.itu.ama.amaProject.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import com.itu.ama.amaProject.model.Technician;

public interface TechnicianRepository extends UserBaseRepository<Technician>{
	
	@Query(value = "SELECT * FROM TECHNICIAN WHERE GROUP_ID= ?1", nativeQuery = true)
	Collection<Technician> findByHomeGroupId(Long id);

}
