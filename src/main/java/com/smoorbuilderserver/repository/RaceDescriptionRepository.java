package com.smoorbuilderserver.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smoorbuilderserver.model.RaceDescription;

@Repository
public interface RaceDescriptionRepository extends CrudRepository<RaceDescription, BigInteger> {
	
	public RaceDescription findByRaceName(String raceName);
	
	public RaceDescription findByid(BigInteger id);
	
	public List<RaceDescription> findDistinctRaceDescriptionByRaceName(String raceName);
}