package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.CombatActionDescription;
import com.smoorbuilderserver.repository.CombatActionDescriptionRepository;

public class SeedCombatActionDescriptions {
	
	private CombatActionDescriptionRepository combatActionDescriptionRepository;
	
	ObjectMapper combatActionDescriptionMapper = new ObjectMapper();
	
	TypeReference<List<CombatActionDescription>> combatActionDescriptionTypeReference = 
			new TypeReference<List<CombatActionDescription>>() {};
			
	public void saveCombatActionDescriptions(List<CombatActionDescription> combatActionDescriptions) {
		combatActionDescriptionRepository.saveCombatActionDescription(combatActionDescriptions);
	}

	
	public void seedCombatActionDescriptions(String path) {
		InputStream combatActionDescriptionInputStream = 
				TypeReference.class.getResourceAsStream(path + "combat-action-description.json");
		try {
			List<CombatActionDescription> combatActionDescriptions = 
					combatActionDescriptionMapper.readValue(combatActionDescriptionInputStream, combatActionDescriptionTypeReference);
			saveCombatActionDescriptions(combatActionDescriptions);
			System.out.println(">>>>>Combat Actions Added");
			
		} catch(Exception e){
			System.out.println(">>>>>Error Adding Combat Actions: " + e);
		}
	}
}

