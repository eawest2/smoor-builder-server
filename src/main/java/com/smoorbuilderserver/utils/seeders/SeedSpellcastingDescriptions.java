package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.SpellcastingDescription;
import com.smoorbuilderserver.repository.SpellcastingDescriptionRepository;

@Component
public class SeedSpellcastingDescriptions {
	
	@Autowired
	private SpellcastingDescriptionRepository spellcastingDescriptionRepository;
	
	ObjectMapper spellcastingDescriptionMapper = new ObjectMapper();
	
	InputStream spellcastingDescriptionInputStream = 
			TypeReference.class.getResourceAsStream("/spellcasting-description.json");
	
	public void seedSpellcastingDescriptions() {
		
		SpellcastingDescription exists = spellcastingDescriptionRepository.findBySpellcastingName("Celestial Generalist");
		
		if(exists != null) {
			System.out.println(">>>>>Spellcasting Descriptions exist, seeding not needed.");
		}
		else{
			try {
				SpellcastingDescription[] spellcastingDescriptions = 
						spellcastingDescriptionMapper.readValue(spellcastingDescriptionInputStream, SpellcastingDescription[].class);
				List<SpellcastingDescription> seedSpellcastingList = Arrays.asList(spellcastingDescriptions);
				spellcastingDescriptionRepository.saveAll(seedSpellcastingList);
				System.out.println(">>>>>Spellcasting Description Added");
				
			} catch(Exception e){
				System.out.println(">>>>>Error Adding Spellcasting Description: " + e);
			}
		}
		
	}
}

