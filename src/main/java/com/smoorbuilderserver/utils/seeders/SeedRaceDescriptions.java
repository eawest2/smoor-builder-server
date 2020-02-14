package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.RaceDescription;
import com.smoorbuilderserver.repository.RaceDescriptionRepository;

@Component
public class SeedRaceDescriptions {
	
	@Autowired
	private RaceDescriptionRepository raceDescriptionRepository;
	
	ObjectMapper raceDescriptionMapper = new ObjectMapper();
	
	InputStream raceDescriptionInputStream = 
			TypeReference.class.getResourceAsStream("/race-description.json");
	
	public void seedRaceDescriptions() {
		
		RaceDescription exists = raceDescriptionRepository.findByRaceName("Surface Elf");
		
		if(exists != null) {
			System.out.println(">>>>>Races exist, seeding not needed.");
		}
		else{
		
			try {
				RaceDescription[] generalSkillDescriptions = 
						raceDescriptionMapper.readValue(raceDescriptionInputStream, RaceDescription[].class);
				List<RaceDescription> seedGenseralSkillDescriptionList = Arrays.asList(generalSkillDescriptions);
				raceDescriptionRepository.saveAll(seedGenseralSkillDescriptionList);
				System.out.println(">>>>>Races Added");
				
			} catch(Exception e){
				System.out.println(">>>>>Error Adding Races: " + e);
			}
		}
	}
}

