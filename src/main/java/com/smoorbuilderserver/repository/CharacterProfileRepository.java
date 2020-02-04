package com.smoorbuilderserver.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.CharacterProfile;

@Repository
public interface CharacterProfileRepository extends CrudRepository<CharacterProfile, Long> {
	
	public CharacterProfile findByUserId (Long userId);
	
	public CharacterProfile findByid(Long id);
	
	public CharacterProfile findByCharacterName(String characterName);
	
	public List<CharacterProfile> findDistinctCharacterProfileByCharacterName(String characterName);	
}