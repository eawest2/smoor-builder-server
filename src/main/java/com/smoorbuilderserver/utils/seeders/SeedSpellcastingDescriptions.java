//package com.smoorbuilderserver.utils.seeders;
//
//import java.io.InputStream;
//import java.util.List;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.smoorbuilderserver.model.SpellcastingDescription;
//import com.smoorbuilderserver.repository.SpellcastingDescriptionRepository;
//
//public class SeedSpellcastingDescriptions {
//	
//	private SpellcastingDescriptionRepository spellcastingDescriptionRepository;
//	
//	ObjectMapper spellcastingDescriptionMapper = new ObjectMapper();
//	
//	TypeReference<List<SpellcastingDescription>> spellcastingDescriptionTypeReference = 
//			new TypeReference<List<SpellcastingDescription>>() {};
//			
//	public void saveSpellcastingDescriptions(List<SpellcastingDescription> spellcastingDescriptions) {
//		spellcastingDescriptionRepository.saveSpellcastingDescriptions(spellcastingDescriptions);
//	}
//
//	public void seedClassDescriptions(String path) {
//		InputStream spellcastingDescriptionRepository = 
//				TypeReference.class.getResourceAsStream(path + "spellcasting-description.json");
//		try {
//			List<SpellcastingDescription> classDescriptions = 
//					spellcastingDescriptionMapper.readValue(spellcastingDescriptionRepository, spellcastingDescriptionTypeReference);
//			saveSpellcastingDescriptions(classDescriptions);
//			System.out.println(">>>>>Class Descriptions Added");
//			
//		} catch(Exception e){
//			System.out.println(">>>>>Error Adding Class Descriptions: " + e);
//		}
//	}
//}
//
