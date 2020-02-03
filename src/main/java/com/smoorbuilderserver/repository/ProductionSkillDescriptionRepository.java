package com.smoorbuilderserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.ProductionSkillDescription;

@Repository
public interface ProductionSkillDescriptionRepository extends CrudRepository<ProductionSkillDescription, Long> {
	
	public ProductionSkillDescription findByProductionSkillName(String productionlName);
	
	public ProductionSkillDescription findByid(Integer id);
	
	public List<ProductionSkillDescription> findDistinctProductionSkillDescriptionByProductionSkillName(String productionName);
}