package com.smoorbuilderserver.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.GeneralSkillDescription;

@Repository
public interface GeneralSkillDescriptionRepository extends CrudRepository<GeneralSkillDescription, BigInteger> {
	
	public GeneralSkillDescription findByGeneralSkillName(String generalSkillName);
	
	public GeneralSkillDescription findByid(BigInteger id);
	
	public List<GeneralSkillDescription> findDistinctGeneralSkillDescriptionByGeneralSkillName(String generalSkillName);
}