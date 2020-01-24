package com.smoorbuilderserver.utils;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.ClassDescription;
import com.smoorbuilderserver.model.CombatActionDescription;
import com.smoorbuilderserver.model.GeneralSkillDescription;
import com.smoorbuilderserver.model.RaceDescription;
import com.smoorbuilderserver.repository.ClassDescriptionRepository;
import com.smoorbuilderserver.repository.CombatActionDescriptionRepository;
import com.smoorbuilderserver.repository.GeneralSkillDescriptionRepository;
import com.smoorbuilderserver.repository.RaceDescriptionRepository;

public class Seeder {
	
	// Seeder must ingest a json object and save it to the DB
	//JSON must be formatted such that Jackson can know how to parse it properly.
	//Generate manual mapping inside of the seeder?
	private CombatActionDescriptionRepository combatActionDescriptionRepository;
	private RaceDescriptionRepository raceDescriptionRepository;
	private GeneralSkillDescriptionRepository generalSkillDescriptionRepository;
	private ClassDescriptionRepository classDescriptionRepository;
	
	ObjectMapper combatActionDescriptionMapper = new ObjectMapper();
	ObjectMapper raceDescriptionMapper = new ObjectMapper();
	ObjectMapper generalSkillDescriptionMapper = new ObjectMapper();
	ObjectMapper classDescriptionMapper = new ObjectMapper();
	
	TypeReference<List<CombatActionDescription>> combatActionDescriptionTypeReference = 
			new TypeReference<List<CombatActionDescription>>() {};
	
	TypeReference<List<RaceDescription>> raceDescriptionTypeReference = 
			new TypeReference<List<RaceDescription>>() {};		
			
	TypeReference<List<GeneralSkillDescription>> generalSkillDescriptionTypeReference = 
			new TypeReference<List<GeneralSkillDescription>>() {};
			
	TypeReference<List<ClassDescription>> classDescriptionsTypeReference = 
			new TypeReference<List<ClassDescription>>() {};
			
	public void saveCombatActionDescriptions(List<CombatActionDescription> combatActionDescriptions) {
		combatActionDescriptionRepository.saveCombatActionDescription(combatActionDescriptions);
	}
	
	public void saveRaceDescriptions(List<RaceDescription> raceDescriptions) {
		raceDescriptionRepository.saveRaceDescription(raceDescriptions);
	}
	
	public void saveGeneralSkillDescriptions(List<GeneralSkillDescription> generalSkillDescriptions) {
		generalSkillDescriptionRepository.saveGeneralSkillDescriptions(generalSkillDescriptions);
	}
	
	public void saveClassDescription(List<ClassDescription> classDescriptions) {
		classDescriptionRepository.saveClassDescriptions(classDescriptions);
	}
	
};