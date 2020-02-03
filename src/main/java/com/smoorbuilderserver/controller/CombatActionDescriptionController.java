package com.smoorbuilderserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smoorbuilderserver.model.CombatActionDescription;
import com.smoorbuilderserver.repository.CombatActionDescriptionRepository;
import com.smoorbuilderserver.utils.ApiResponse;




@Controller
@RequestMapping(path="/api")

public class CombatActionDescriptionController {
	
	@Autowired 
	private CombatActionDescriptionRepository combatActionDescriptionRepository;

	@PostMapping(path="/cad")
	public @ResponseBody ResponseEntity<?> addNewUser (@RequestBody CombatActionDescription cad) {
		String newActionName = cad.getActionName();
		CombatActionDescription actionSearch = combatActionDescriptionRepository.findByActionName(newActionName);
	    
		if (actionSearch == null) {
			combatActionDescriptionRepository.save(cad);
			
			
			return new ResponseEntity<>(cad, HttpStatus.CREATED);
	    } else {
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(409);
	    	apiResponse.setResponseOrigin("/cad, New CAD Creation");
	    	apiResponse.setResponseText("This CAD already exists, please try another.");
	    	
	        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT); 
	    }
	}
	
}