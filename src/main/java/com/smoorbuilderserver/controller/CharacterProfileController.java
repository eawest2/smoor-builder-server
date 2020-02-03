package com.smoorbuilderserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smoorbuilderserver.model.CharacterProfile;
import com.smoorbuilderserver.repository.CharacterProfileRepository;
import com.smoorbuilderserver.utils.ApiResponse;




@Controller
@RequestMapping(path="/api")

public class CharacterProfileController {
	
	@Autowired 
	private CharacterProfileRepository characterProfileRepository;

	@PostMapping(path="/character")
	public @ResponseBody ResponseEntity<?> addNewCharacterProfile (@RequestBody CharacterProfile characterProfile) {
		String newCharacterName = characterProfile.getCharacterName();
		CharacterProfile actionSearch = characterProfileRepository.findByCharacterName(newCharacterName);
	    
		if (actionSearch == null) {
			System.out.println(">>>>>Character Controller - Start Save");
			characterProfileRepository.save(characterProfile);
			
			
			return new ResponseEntity<>(characterProfile, HttpStatus.CREATED);
	    } else {
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(409);
	    	apiResponse.setResponseOrigin("/character, New Character Creation");
	    	apiResponse.setResponseText("This Character already exists, please try another.");
	    	
	        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT); 
	    }
	}
}