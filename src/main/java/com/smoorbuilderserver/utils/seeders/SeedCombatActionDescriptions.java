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
		System.out.println(">>>>>Before CADseeder saveAll");
		combatActionDescriptionRepository.saveAll(combatActionDescriptions);
	}
	
	public void seedCombatActionDescriptions(String path) {
		System.out.println(">>>>>CAD Seeder start");
		System.out.println(path + "combat-action-description.json");
		
		InputStream combatActionDescriptionInputStream = 
				TypeReference.class.getResourceAsStream("combat-action-description.json");
		
		System.out.println(">>>>>> Input Stream Output" + combatActionDescriptionInputStream);
		String listout = System.getProperty("user.dir");
		
		System.out.println(">>>>> Listing root directory: " + listout);
		
//		InputStream input = new FileInputStream("\\bin\\main\\json\\seed\\" + "combat-action-description.json");
		
		try {
			System.out.println(">>>>>CAD Seeder TryCatch Start");
			List<CombatActionDescription> combatActionDescriptions = 
					combatActionDescriptionMapper.readValue(combatActionDescriptionInputStream, combatActionDescriptionTypeReference);
			System.out.println(">>>>> List of combat actions" + combatActionDescriptions);
			saveCombatActionDescriptions(combatActionDescriptions);
			System.out.println(">>>>>Combat Actions Added");
			
		} catch(Exception e){
			System.out.println(">>>>>Error Adding Combat Actions: " + e);
		}
	}
}

