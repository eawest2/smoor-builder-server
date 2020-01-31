package com.smoorbuilderserver.utils.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

@Component
public class Seeder {
	
	@Autowired
	SeedCombatActionDescriptions seedCombatActions;
	
	public void	runSeeder(ApplicationReadyEvent event) {
		System.out.println(">Seeder Start");
		System.out.println(">>>Combat Action Description Seeder Start");
		seedCombatActions.seedCombatActionDescriptions();
	}
};