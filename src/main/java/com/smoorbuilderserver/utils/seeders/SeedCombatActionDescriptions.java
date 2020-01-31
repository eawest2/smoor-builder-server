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
	
	InputStream combatActionDescriptionInputStream = 
			TypeReference.class.getResourceAsStream("/combat-action-description.json");
			
	public void saveCombatActionDescriptions(List<CombatActionDescription> combatActionDescriptions) {

		combatActionDescriptionRepository.saveAll(combatActionDescriptions);
	}
	
	public void seedCombatActionDescriptions() {
		
		try {
			System.out.println(">>>>>CAD Seeder TryCatch Start");
			CombatActionDescription[] combatActionDescriptions = 
					combatActionDescriptionMapper.readValue(combatActionDescriptionInputStream, CombatActionDescription[].class);
//			for (CombatActionDescription combatActionDescription : combatActionDescriptions)
//			{
//				CombatActionDescriptionRepository.save(deployedCombatDescription);
//			}
			System.out.println(">>>>> List of combat actions" + combatActionDescriptions);
			System.out.println(">>>>>Combat Actions Added");
			
		} catch(Exception e){
			System.out.println(">>>>>Error Adding Combat Actions: " + e);
		}
	}
}

