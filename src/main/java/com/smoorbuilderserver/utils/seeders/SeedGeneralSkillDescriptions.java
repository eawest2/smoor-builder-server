package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.GeneralSkillDescription;
import com.smoorbuilderserver.repository.GeneralSkillDescriptionRepository;

public class SeedGeneralSkillDescriptions {
	
	private GeneralSkillDescriptionRepository generalSkillDescriptionRepository;
	
	ObjectMapper generalSkillDescriptionMapper = new ObjectMapper();
	
	TypeReference<List<GeneralSkillDescription>> generalSkillDescriptionTypeReference = 
			new TypeReference<List<GeneralSkillDescription>>() {};
			
	public void saveGeneralSkillDescriptions(List<GeneralSkillDescription> generalSkillDescriptions) {
		generalSkillDescriptionRepository.saveGeneralSkillDescriptions(generalSkillDescriptions);
	}

	
	public void seedGeneralSkillDescriptions(String path) {
		InputStream generalSkillDescriptionInputStream = 
				TypeReference.class.getResourceAsStream(path + "general-skill-description.json");
		try {
			List<GeneralSkillDescription> generalSkillDescriptions = 
					generalSkillDescriptionMapper.readValue(generalSkillDescriptionInputStream, generalSkillDescriptionTypeReference);
			saveGeneralSkillDescriptions(generalSkillDescriptions);
			System.out.println(">>>>>General Skills Added");
			
		} catch(Exception e){
			System.out.println(">>>>>Error Adding General Skills: " + e);
		}
	}
}

