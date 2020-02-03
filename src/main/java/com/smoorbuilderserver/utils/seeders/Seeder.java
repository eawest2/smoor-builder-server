package com.smoorbuilderserver.utils.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;

@Component
public class Seeder {
	
	@Autowired
	SeedCombatActionDescriptions seedCombatActions;
	
	@Autowired
	SeedGeneralSkillDescriptions seedGeneralSkillDescriptions;
	
	@Autowired
	SeedRaceDescriptions seedRaceDescriptions;
	
	@Autowired
	SeedSpellcastingDescriptions seedSpellcastingDescriptions;
	
	@Autowired
	SeedClassDescriptions seedClassDescriptions;
	
	@Autowired
	SeedProductionSkillDescriptions seedProductionSkillDescriptions;
	
	public void	runSeeder(ApplicationReadyEvent event) {
		System.out.println(">Seeder Start");
		
		System.out.println(">>>Combat Action Description Seeder Start");
		seedCombatActions.seedCombatActionDescriptions();
		
		System.out.println(">>>General Skill Description Seeder Start");
		seedGeneralSkillDescriptions.seedGeneralSkillDescriptions();
		
		System.out.println(">>>Race Description Seeder Start");
		seedRaceDescriptions.seedRaceDescriptions();
		
		System.out.println(">>>Spellcasting Description Seeder Start");
		seedSpellcastingDescriptions.seedSpellcastingDescriptions();
		
		System.out.println(">>>Class Description Seeder Start");
		seedClassDescriptions.seedClassDescriptions();
		
		System.out.println(">>>Production Skill Description Seeder Start");
		seedProductionSkillDescriptions.seedProductionSkillDescriptions();
	}
};