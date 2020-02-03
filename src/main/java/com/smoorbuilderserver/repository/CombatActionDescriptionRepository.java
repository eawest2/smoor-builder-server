package com.smoorbuilderserver.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.CombatActionDescription;

@Repository
public interface CombatActionDescriptionRepository extends CrudRepository<CombatActionDescription, BigInteger> {
	
	public CombatActionDescription findByActionName(String actionName);
	
	public CombatActionDescription findByActionDescription(String actionDescription);
	
	public CombatActionDescription findByid(BigInteger id);
	
	public List<CombatActionDescription> findDistinctCombatActionDescriptionByActionName(String actionName);
}