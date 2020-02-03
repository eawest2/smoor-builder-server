package com.smoorbuilderserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.GeneralSkillDescription;

@Repository
public interface GeneralSkillDescriptionRepository extends CrudRepository<GeneralSkillDescription, Long> {
	
	public GeneralSkillDescription findByGeneralSkillName(String generalSkillName);
	
	public GeneralSkillDescription findByid(Integer id);
	
	public List<GeneralSkillDescription> findDistinctGeneralSkillDescriptionByGeneralSkillName(String generalSkillName);
}