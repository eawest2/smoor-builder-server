package com.smoorbuilderserver.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.SpellcastingDescription;

@Repository
public interface SpellcastingDescriptionRepository extends CrudRepository<SpellcastingDescription, BigInteger> {
	
	public SpellcastingDescription findBySpellcastingName(String generalSkillName);
	
	public SpellcastingDescription findByid(BigInteger id);
	
	public List<SpellcastingDescription> findDistinctSpellcastingDescriptionBySpellcastingName(String spellcastingDescriptionName);
}