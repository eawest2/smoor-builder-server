package com.smoorbuilderserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.CharacterCombatActionInventory;

@Repository
public interface CharacterCombatActionInventoryRepository extends CrudRepository<CharacterCombatActionInventory, Long> {
	
	public CharacterCombatActionInventory findByid(Long id);
	
	public List<CharacterCombatActionInventory> findDistinctCharacterCombatActionInventoryByCharacterCharacterName(String characterName);
}