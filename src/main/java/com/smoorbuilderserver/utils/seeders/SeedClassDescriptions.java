package com.smoorbuilderserver.utils.seeders;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smoorbuilderserver.model.ClassDescription;
import com.smoorbuilderserver.repository.ClassDescriptionRepository;

@Component
public class SeedClassDescriptions {
	
	@Autowired
	private ClassDescriptionRepository classDescriptionRepository;
	
	ObjectMapper classDescriptionMapper = new ObjectMapper();
	
	InputStream classDescriptionInputStream = 
			TypeReference.class.getResourceAsStream("/class-description.json");
	
	public void seedClassDescriptions() {
		
		ClassDescription exists = classDescriptionRepository.findByClassName("Templar");
		
		if(exists != null) {
			System.out.println(">>>>>Classes exist, seeding not needed.");
		}
		else{
			
			try {
				ClassDescription[] classDescriptions = 
						classDescriptionMapper.readValue(classDescriptionInputStream, ClassDescription[].class);
				List<ClassDescription> seedClassList = Arrays.asList(classDescriptions);
				classDescriptionRepository.saveAll(seedClassList);
				System.out.println(">>>>>Classes Added");
				
			} catch(Exception e){
				System.out.println(">>>>>Error Adding Classes: " + e);
			}
		}
	}
}

