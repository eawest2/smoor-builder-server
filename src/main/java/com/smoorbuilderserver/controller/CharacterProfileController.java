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
import com.smoorbuilderserver.model.ClassDescription;
import com.smoorbuilderserver.model.RaceDescription;
import com.smoorbuilderserver.model.User;
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
			System.out.println(">>>>>Character Controller - Begin Interpretation");
			
			//Perform some kind of join in here to make new character option. Utilize class identifiers rather than full class objects.
			
//			User newCharacterUser = characterProfile.getUser();
//			RaceDescription newCharacterRace = characterProfile.getRaceDescription();
//			ClassDescription newCharacterClass = characterProfile.getClassDescription();
			
//			CharacterProfile saveNewCharacter;
//			
//			saveNewCharacter.setCharacterName(characterProfile.getCharacterName());
//			saveNewCharacter.setBackground(characterProfile.getBackground());
//			saveNewCharacter.setBuildTotal(characterProfile.getBuildTotal());
//			saveNewCharacter.setDescription(characterProfile.getDescription());
//			saveNewCharacter.setImage(characterProfile.getImage());
			

			
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