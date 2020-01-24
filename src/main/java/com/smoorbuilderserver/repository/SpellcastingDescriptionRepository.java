package com.smoorbuilderserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.SpellcastingDescription;

@Repository
public interface SpellcastingDescriptionRepository extends CrudRepository<SpellcastingDescription, Long> {
	
	public SpellcastingDescription findBySpellcastingName(String generalSkillName);
	
	public SpellcastingDescription findByid(Integer id);
	
	public List<SpellcastingDescription> findDistinctSpellcastingDescriptionBySpellcastingName(String spellcastingDescriptionName);
	
	public List<SpellcastingDescription> saveSpellcastingDescriptions (List<SpellcastingDescription> list);

}