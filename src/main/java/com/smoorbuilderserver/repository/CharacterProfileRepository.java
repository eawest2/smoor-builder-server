package com.smoorbuilderserver.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.CharacterProfile;

@Repository
public interface CharacterProfileRepository extends CrudRepository<CharacterProfile, BigInteger> {
	
	public CharacterProfile findByUserId (BigInteger userId);
	
	public CharacterProfile findByid(BigInteger id);
	
	public CharacterProfile findByCharacterName(String characterName);
	
	public List<CharacterProfile> findDistinctCharacterProfileByCharacterName(String characterName);	
}