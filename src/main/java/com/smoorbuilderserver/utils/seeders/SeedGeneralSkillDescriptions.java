package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.GeneralSkillDescription;
import com.smoorbuilderserver.repository.GeneralSkillDescriptionRepository;

@Component
public class SeedGeneralSkillDescriptions {
	
	@Autowired
	private GeneralSkillDescriptionRepository generalSkillDescriptionRepository;
	
	ObjectMapper generalSkillDescriptionMapper = new ObjectMapper();
	
	InputStream generalSkillDescriptionInputStream = 
			TypeReference.class.getResourceAsStream("/general-skill-description.json");
	
	public void seedGeneralSkillDescriptions() {
		
		GeneralSkillDescription exists = generalSkillDescriptionRepository.findByGeneralSkillName("Seamanship");
		
		if(exists != null) {
			System.out.println(">>>>>General Skills exist, seeding not needed.");
		}
		else{
			try {
				GeneralSkillDescription[] generalSkillDescriptions = 
						generalSkillDescriptionMapper.readValue(generalSkillDescriptionInputStream, GeneralSkillDescription[].class);
				List<GeneralSkillDescription> seedGenseralSkillDescriptionList = Arrays.asList(generalSkillDescriptions);
				generalSkillDescriptionRepository.saveAll(seedGenseralSkillDescriptionList);
				System.out.println(">>>>>General Skills Added");
				
			} catch(Exception e){
				System.out.println(">>>>>Error Adding General Skills: " + e);
			}
		}
	}
}

