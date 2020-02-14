package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.ProductionSkillDescription;
import com.smoorbuilderserver.repository.ProductionSkillDescriptionRepository;

@Component
public class SeedProductionSkillDescriptions {
	
	@Autowired
	private ProductionSkillDescriptionRepository productionSkillDescriptionRepository;
	
	ObjectMapper productionSkillDescriptionMapper = new ObjectMapper();
	
	InputStream productionSkillDescriptionInputStream = 
			TypeReference.class.getResourceAsStream("/production-skill-description.json");
	
	public void seedProductionSkillDescriptions() {
		ProductionSkillDescription exists = productionSkillDescriptionRepository.findByProductionSkillName("Create Poison");
		
		if(exists != null) {
			System.out.println(">>>>>Production Skills exist, seeding not needed.");
		}
		else{
		
			try {
				ProductionSkillDescription[] productionSkillDescriptions = 
						productionSkillDescriptionMapper.readValue(productionSkillDescriptionInputStream, ProductionSkillDescription[].class);
				List<ProductionSkillDescription> seedProductionSkillDescriptionList = Arrays.asList(productionSkillDescriptions);
				productionSkillDescriptionRepository.saveAll(seedProductionSkillDescriptionList);
				System.out.println(">>>>>Production Skills Added");
				
			} catch(Exception e){
				System.out.println(">>>>>Error Adding Production Skills: " + e);
			}
		}
	}
}

