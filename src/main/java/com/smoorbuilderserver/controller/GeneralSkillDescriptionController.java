//package com.smoorbuilderserver.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.smoorbuilderserver.model.GeneralSkillDescription;
//import com.smoorbuilderserver.repository.GeneralSkillDescriptionRepository;
//import com.smoorbuilderserver.utils.ApiResponse;
//
//
//@Controller
//@RequestMapping(path="/api")
//
//public class GeneralSkillDescriptionController {
//	@Autowired 
//	private GeneralSkillDescriptionRepository GeneralSkillDescriptionRepository;
//
//	@PostMapping(path="/skill")
//	public @ResponseBody ResponseEntity<?> addNewGeneralSkill (@RequestBody GeneralSkillDescription newSkill) {
//		String newSkillName = newSkill.getGeneralSkillName();
//		GeneralSkillDescription generalSkillNameSearch = GeneralSkillDescriptionRepository.findByGeneralSkillName(newSkillName);
//	    
//		if (generalSkillNameSearch == null) {
//			GeneralSkillDescriptionRepository.save(newSkill);
//			
//			
//			return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
//	    } else {
//	    	Long existingGeneralSkillId = generalSkillNameSearch.getId();
//	    	ApiResponse apiResponse = new ApiResponse();
//	    	apiResponse.setResponseCode(409);
//	    	apiResponse.setResponseOrigin("/skill, New General Skill Creation");
//	    	apiResponse.setResponseText("This General Skill already exists under an ID of: '" 
//	    	+ existingGeneralSkillId + "', please try another.");
//	    	
//	        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT); 
//	    }
//	}
//
//	@GetMapping(path="/skill")
//	public @ResponseBody Iterable<GeneralSkillDescription> getAllSkillDescription() {
//		return GeneralSkillDescriptionRepository.findAll();
//	}
//	
//	@GetMapping(path="/skill/{id}")
//	public ResponseEntity<?> read(@PathVariable("id") Long id) {
//		GeneralSkillDescription generalSkillDescriptionSearch = GeneralSkillDescriptionRepository.findById(id).get();
//	    if (generalSkillDescriptionSearch == null) {
//	    	ApiResponse apiResponse = new ApiResponse();
//	    	apiResponse.setResponseCode(400);
//	    	apiResponse.setResponseOrigin("/user/{id}, User Lookup by ID");
//	    	apiResponse.setResponseText("Your request is incorrectly formatted, please try again.");
//	        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
//	    } else {
//	        return new ResponseEntity<>(generalSkillDescriptionSearch, HttpStatus.OK);
//	    }
//	}
//	
//	@GetMapping(path="/skill/skillname/{skillname}")
//	public ResponseEntity<?> read(@PathVariable("skillname") String generalSkillName) {
//		GeneralSkillDescription generalSkillDescriptionNameSearch = GeneralSkillDescriptionRepository.findByGeneralSkillName(generalSkillName);
//	    if (generalSkillDescriptionNameSearch == null) {
//	    	ApiResponse apiResponse = new ApiResponse();
//	    	apiResponse.setResponseCode(200);
//	    	apiResponse.setResponseOrigin("/skill/skillname/{skillname}}, User Lookup by Skill Name");
//	    	apiResponse.setResponseText("Skill Name not found.");
//	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(generalSkillDescriptionNameSearch, HttpStatus.OK);
//	    }
//	}
//	
//	@PutMapping(path="/skill/{id}")
//	public @ResponseBody ResponseEntity<?> updateGeneralSkillDescriptionById(@PathVariable long id, @RequestBody GeneralSkillDescription skillDescription) {
//		GeneralSkillDescription existingSkillDescription = GeneralSkillDescriptionRepository.findById(id).get();
//				
//		if  (existingSkillDescription != null) {
//			existingSkillDescription.setGeneralSkillName(skillDescription.getGeneralSkillName());
//			existingSkillDescription.setGeneralSkillDescription(skillDescription.getGeneralSkillDescription());
//			existingSkillDescription.setGeneralSkillCost(skillDescription.getGeneralSkillCost());
//			existingSkillDescription.setGeneralSkillCost(skillDescription.getGeneralSkillCost());
//			GeneralSkillDescriptionRepository.save(existingSkillDescription);
//			
//	    	ApiResponse apiResponse = new ApiResponse();
//	    	apiResponse.setResponseCode(202);
//	    	apiResponse.setResponseOrigin("/user/{id}, User Update by ID");
//	    	apiResponse.setResponseText("User has been updated.");
//			
//			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
//		}
//		else {
//			
//	    	ApiResponse apiResponse = new ApiResponse();
//	    	apiResponse.setResponseCode(400);
//	    	apiResponse.setResponseOrigin("/user/{id}, User Update by ID");
//	    	apiResponse.setResponseText("User does not exist.");
//			
//			return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
//		}
//	}
//}