package com.smoorbuilderserver.utils.seeders;

import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;

public class Seeder {
	
	String jsonPath = "\\bin\\main\\seed\\";
	
	SeedCombatActionDescriptions seedCombatActions = new SeedCombatActionDescriptions();
	
//	@EventListener (ContextRefreshedEvent.class)
	public void	runSeeder(ContextRefreshedEvent event) {
		System.out.println(">>>>>Seeder Start");
		seedCombatActions.seedCombatActionDescriptions();	
	}
};