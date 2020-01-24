package com.smoorbuilderserver.utils.seeders;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.smoorbuilderserver.utils.seeders.SeedCombatActionDescriptions;

public class Seeder {
	
	String jsonPath = "/src/main/resources/json/seed/";
	
	SeedCombatActionDescriptions seedCombatActions = new SeedCombatActionDescriptions();
	
	@EventListener
	public void	runSeeder(ContextRefreshedEvent event) {
		
		seedCombatActions.seedCombatActionDescriptions(jsonPath);	
	}
};