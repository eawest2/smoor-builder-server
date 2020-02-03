package com.smoorbuilderserver.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, BigInteger> {
	
	public User findByUsername(String username);
	
	public User findByid(Integer id);
	
	public List<User> findDistinctUserByFirstName(String firstName);
	
	public List<User> findDistinctUserByFirstNameAndLastName(String firstName, String lastName);
	
}