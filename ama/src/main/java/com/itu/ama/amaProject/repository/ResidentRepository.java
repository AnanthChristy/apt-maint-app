package com.itu.ama.amaProject.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;

import com.itu.ama.amaProject.model.Resident;

@Transactional
public interface ResidentRepository extends UserBaseRepository<Resident>{

	@Query(value = "SELECT * FROM RESIDENT WHERE GROUP_ID= ?1", nativeQuery = true)
	public Collection<Resident> getResidentsByGroupID(Long id);
	
}
