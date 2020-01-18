package com.smoorbuilderserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	
	public List<User> findDistinctUserByFirstname(String firstname);
	
	public List<User> findDistinctUserByFirstnameAndLastname(String firstname, String lastname);
	
}