//package com.smoorbuilderserver.repository;
//
//import java.util.List;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.smoorbuilderserver.model.RaceDescription;
//
//@Repository
//public interface RaceDescriptionRepository extends CrudRepository<RaceDescription, Long> {
//	
//	public RaceDescription findByRaceName(String raceName);
//	
//	public RaceDescription findByid(Integer id);
//	
//	public List<RaceDescription> findDistinctRaceDescriptionByRaceName(String raceName);
//	
//	public List<RaceDescription> saveRaceDescription (List<RaceDescription> list);
//}