package com.smoorbuilderserver.utils;

import java.util.List;

import com.smoorbuilderserver.model.CombatActionDescription;
import com.smoorbuilderserver.repository.CombatActionDescriptionRepository;

public class Seeder {
	
	// Seeder must ingest a json object and save it to the DB
	//JSON must be formatted such that Jackson can know how to parse it properly.
	//Generate manual mapping inside of the seeder?
	private CombatActionDescriptionRepository combatActionDescriptionRepository;
	
	public void saveCombatActionDescriptions(List<CombatActionDescription> combatActionDescriptions) {
		combatActionDescriptionRepository.saveCombatActionDescription(combatActionDescriptions);
	}
	
};