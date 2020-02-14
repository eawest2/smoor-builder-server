package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.CombatActionDescription;
import com.smoorbuilderserver.repository.CombatActionDescriptionRepository;

@Component
public class SeedCombatActionDescriptions {
	
	@Autowired
	private CombatActionDescriptionRepository combatActionDescriptionRepository;
	
	ObjectMapper combatActionDescriptionMapper = new ObjectMapper();
	
	InputStream combatActionDescriptionInputStream = 
			TypeReference.class.getResourceAsStream("/combat-action-description.json");
	
	public void seedCombatActionDescriptions() {
		
		CombatActionDescription exists = combatActionDescriptionRepository.findByActionName("Critical Slay");
		
		if(exists != null) {
			System.out.println(">>>>>Combat Actions exist, seeding not needed.");
		}
		else {
			try {
				CombatActionDescription[] combatActionDescriptions = 
						combatActionDescriptionMapper.readValue(combatActionDescriptionInputStream, CombatActionDescription[].class);
				List<CombatActionDescription> seedCADList = Arrays.asList(combatActionDescriptions);
				combatActionDescriptionRepository.saveAll(seedCADList);
				System.out.println(">>>>>Combat Actions Added");
				
			} catch(Exception e){
				System.out.println(">>>>>Error Adding Combat Actions: " + e);
			}
		}
		
		
	}
}

