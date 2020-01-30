//package com.smoorbuilderserver.utils.seeders;
//
//import java.io.InputStream;
//import java.util.List;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.smoorbuilderserver.model.ClassDescription;
//import com.smoorbuilderserver.repository.ClassDescriptionRepository;
//
//public class SeedClassDescriptions {
//	
//	private ClassDescriptionRepository classDescriptionRepository;
//	
//	ObjectMapper classDescriptionMapper = new ObjectMapper();
//	
//	TypeReference<List<ClassDescription>> classDescriptionsTypeReference = 
//			new TypeReference<List<ClassDescription>>() {};
//			
//	public void saveClassDescription(List<ClassDescription> classDescriptions) {
//		classDescriptionRepository.saveClassDescriptions(classDescriptions);
//	}
//
//	
//	public void seedClassDescriptions(String path) {
//		InputStream classDescriptionInputStream = 
//				TypeReference.class.getResourceAsStream(path + "class-description.json");
//		try {
//			List<ClassDescription> classDescriptions = 
//					classDescriptionMapper.readValue(classDescriptionInputStream, classDescriptionsTypeReference);
//			saveClassDescription(classDescriptions);
//			System.out.println(">>>>>Class Descriptions Added");
//			
//		} catch(Exception e){
//			System.out.println(">>>>>Error Adding Class Descriptions: " + e);
//		}
//	}
//}
//
