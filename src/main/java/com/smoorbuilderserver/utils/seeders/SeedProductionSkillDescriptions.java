//package com.smoorbuilderserver.utils.seeders;
//
//import java.io.InputStream;
//import java.util.List;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.smoorbuilderserver.model.ProductionSkillDescription;
//import com.smoorbuilderserver.repository.ProductionSkillDescriptionRepository;
//
//public class SeedProductionSkillDescriptions {
//	
//	private ProductionSkillDescriptionRepository productionSkillDescriptionRepository;
//	
//	ObjectMapper productionSkillDescriptionMapper = new ObjectMapper();
//	
//	TypeReference<List<ProductionSkillDescription>> productionSkillDescriptionTypeReference = 
//			new TypeReference<List<ProductionSkillDescription>>() {};
//	
//	public void saveProductionSkillDescription(List<ProductionSkillDescription> productionSkillDescriptions) {
//		productionSkillDescriptionRepository.saveProductionSkillDescriptions(productionSkillDescriptions);
//	}
//
//	
//	public void seedCombatActionDescriptions(String path) {
//		InputStream productionSkillDescriptionInputStream = 
//				TypeReference.class.getResourceAsStream(path + "production-skill-description.json");
//		try {
//			List<ProductionSkillDescription> combatActionDescriptions = 
//					productionSkillDescriptionMapper.readValue(productionSkillDescriptionInputStream, productionSkillDescriptionTypeReference);
//			saveProductionSkillDescription(combatActionDescriptions);
//			System.out.println(">>>>>Production Skills Added");
//			
//		} catch(Exception e){
//			System.out.println(">>>>>Error Adding Production Skills: " + e);
//		}
//	}
//}
//
