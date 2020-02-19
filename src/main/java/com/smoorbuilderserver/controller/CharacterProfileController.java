package com.smoorbuilderserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smoorbuilderserver.model.CharacterCombatActionInventory;
import com.smoorbuilderserver.model.CharacterProfile;
import com.smoorbuilderserver.repository.CharacterCombatActionInventoryRepository;
import com.smoorbuilderserver.repository.CharacterProfileRepository;
import com.smoorbuilderserver.utils.ApiResponse;



@Controller
@RequestMapping(path="/api")

public class CharacterProfileController {
	
	@Autowired 
	private CharacterProfileRepository characterProfileRepository;
	
	@Autowired 
	private CharacterCombatActionInventoryRepository characterCombatActionInventoryRepository;

	@PostMapping(path="/character")
	public @ResponseBody ResponseEntity<?> addNewCharacterProfile (@RequestBody CharacterProfile characterProfile) {
		String newCharacterName = characterProfile.getCharacterName();
		CharacterProfile actionSearch = characterProfileRepository.findByCharacterName(newCharacterName);
		
		if (actionSearch == null) {
			
			System.out.println(">>>>>Character Controller - Saving new Character");
			characterProfileRepository.save(characterProfile);
			
			ApiResponse apiResponse = new ApiResponse();
			apiResponse.setResponseCode(200);
	    	apiResponse.setResponseOrigin("/character, New Character Creation");
	    	apiResponse.setResponseText("Your character '" + newCharacterName + "' has been created.");
	    	
			return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	    } else {
			System.out.println(">>>>>Character Controller - Existing Character Name Selected, bouncing.");
	    	
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(409);
	    	apiResponse.setResponseOrigin("/character, New Character Creation");
	    	apiResponse.setResponseText("This Character already exists, please try another.");
	    	
	        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT); 
	    }
	}
	
	@PostMapping(path="/character/action")
	public @ResponseBody ResponseEntity<?> addNewCharacterAction (@RequestBody CharacterCombatActionInventory characterAction) {
		ApiResponse apiResponse = new ApiResponse();
		String newActionName = characterAction.getAction_name();
		String characterName = characterAction.getCharacter_name();
		Integer newActionTotal = characterAction.getCharacterCombatActionTotal();
		
		List <CharacterCombatActionInventory> nameSearch = characterCombatActionInventoryRepository.findDistinctCharacterCombatActionInventoryByCharacterCharacterName(characterName);
		
		if (nameSearch.isEmpty() == false) {			
			for(CharacterCombatActionInventory item : nameSearch)if (item.getCombatActionDescription().getActionName().equals(newActionName)) {
				
				if (item.getCharacterCombatActionTotal().equals(newActionTotal)) {
					apiResponse.setResponseCode(204);
			    	apiResponse.setResponseOrigin("/character/action, New Character Action Creation");
			    	apiResponse.setResponseText("This Character already possess this action, please try another.");
					return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
				}
				else {
					System.out.println(">>>>>Character/Action Controller - Updating Character Action Count");
					
					item.setCharacterCombatActionTotal(newActionTotal);
					characterCombatActionInventoryRepository.save(item);
					
					apiResponse.setResponseCode(200);
					apiResponse.setResponseOrigin("/character/action, New Character Action Creation");
			    	apiResponse.setResponseText("Changed " + newActionName + " count to " + newActionTotal + ".");
					
					return new ResponseEntity<>(apiResponse, HttpStatus.OK);
				}
			}
		}
		else {
			System.out.println(">>>>>Character/Action Controller - Adding new Character Action");
			
			characterCombatActionInventoryRepository.save(characterAction);
			
			apiResponse.setResponseCode(201);
			apiResponse.setResponseOrigin("/character/action, New Character Action Creation");
	    	apiResponse.setResponseText("Added new action " + newActionName + " to " + characterName + ".");
			
			return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
		}
		apiResponse.setResponseCode(400);
    	apiResponse.setResponseOrigin("/character/action, New Character Action Creation");
    	apiResponse.setResponseText("The Server could not process your request");
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}
}