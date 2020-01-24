package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.RaceDescription;
import com.smoorbuilderserver.repository.RaceDescriptionRepository;

public class SeedRaceDescriptions {
	
	private RaceDescriptionRepository raceDescriptionRepository;
	
	ObjectMapper raceDescriptionMapper = new ObjectMapper();
	
	TypeReference<List<RaceDescription>> raceDescriptionTypeReference = 
			new TypeReference<List<RaceDescription>>() {};	
			
	public void saveRaceDescriptions(List<RaceDescription> raceDescriptions) {
		raceDescriptionRepository.saveRaceDescription(raceDescriptions);
	}

	public void seedRaceDescriptions(String path) {
		InputStream raceDescriptionInputStream = 
				TypeReference.class.getResourceAsStream(path + "race-description.json");
		try {
			List<RaceDescription> classDescriptions = 
					raceDescriptionMapper.readValue(raceDescriptionInputStream, raceDescriptionTypeReference);
			saveRaceDescriptions(classDescriptions);
			System.out.println(">>>>>Race Descriptions Added");
			
		} catch(Exception e){
			System.out.println(">>>>>Error Adding Race Descriptions: " + e);
		}
	}
}

