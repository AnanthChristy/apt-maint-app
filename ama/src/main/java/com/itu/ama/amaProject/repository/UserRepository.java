package com.itu.ama.amaProject.repository;

import javax.transaction.Transactional;

import com.itu.ama.amaProject.model.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User>{

}
