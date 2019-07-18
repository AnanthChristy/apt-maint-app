package com.itu.ama.amaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.itu.ama.amaProject.model.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T,Long> {
	

}
