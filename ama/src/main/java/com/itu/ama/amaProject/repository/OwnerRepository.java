package com.itu.ama.amaProject.repository;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;

import com.itu.ama.amaProject.model.Owner;

@Transactional
public interface OwnerRepository extends UserBaseRepository<Owner>{

	@Query(value = "SELECT * FROM OWNER WHERE GROUP_ID= ?1", nativeQuery = true)
	public Collection<Owner> getOwnersByGroupID(Long id);
	
}
