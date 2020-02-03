package com.smoorbuilderserver.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.ClassDescription;

@Repository
public interface ClassDescriptionRepository extends CrudRepository<ClassDescription, BigInteger> {
	
	public ClassDescription findByClassName(String generalClassName);
	
	public ClassDescription findByid(BigInteger id);
	
	public List<ClassDescription> findDistinctClassDescriptionByClassName(String generalClassName);
}