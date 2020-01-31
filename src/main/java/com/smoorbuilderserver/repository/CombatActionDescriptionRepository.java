package com.smoorbuilderserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.CombatActionDescription;

@Repository
public interface CombatActionDescriptionRepository extends CrudRepository<CombatActionDescription, Long> {
	
	public CombatActionDescription findByActionName(String actionName);
	
	public CombatActionDescription findByid(Integer id);
	
	public List<CombatActionDescription> findDistinctCombatActionDescriptionByActionName(String actionName);

}