package com.smoorbuilderserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smoorbuilderserver.model.User;
import com.smoorbuilderserver.repository.UserRepository;
import com.smoorbuilderserver.utils.ApiResponse;
import com.smoorbuilderserver.utils.PasswordChange;


@Controller
@RequestMapping(path="/api")

public class UserController {
	@Autowired 
	private UserRepository userRepository;

	@PostMapping(path="/user")
	public @ResponseBody ResponseEntity<?> addNewUser (@RequestBody User user) {
		String newUsername = user.getUsername();
		User userSearch = userRepository.findByUsername(newUsername);
	    
		if (userSearch == null) {
			userRepository.save(user);
			
			return new ResponseEntity<>(user, HttpStatus.CREATED);
	    } else {
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(409);
	    	apiResponse.setResponseOrigin("/user, New User Creation");
	    	apiResponse.setResponseText("This username already exists, please try another.");
	    	
	        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT); 
	    }
	}

	@GetMapping(path="/user")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/user/{id}")
	public ResponseEntity<?> read(@PathVariable("id") Long id) {
	    User userSearch = userRepository.findById(id).get();
	    if (userSearch == null) {
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(400);
	    	apiResponse.setResponseOrigin("/user/{id}, User Lookup by ID");
	    	apiResponse.setResponseText("Your request is incorrectly formatted, please try again.");
	        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	    } else {
	        return new ResponseEntity<>(userSearch, HttpStatus.OK);
	    }
	}
	
	@GetMapping(path="/user/username/{username}")
	public ResponseEntity<?> read(@PathVariable("username") String username) {
	    User userSearch = userRepository.findByUsername(username);
	    if (userSearch == null) {
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(200);
	    	apiResponse.setResponseOrigin("/user/username/{username}, User Lookup by Username");
	    	apiResponse.setResponseText("Username not found.");
	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(userSearch, HttpStatus.OK);
	    }
	}
	
	@GetMapping(path="/user/first/{firstName}")
	public ResponseEntity<?> getByFirstName(@PathVariable("firstName") String firstName) {
		List <User> userSearch = userRepository.findDistinctUserByFirstname(firstName);
	    if (userSearch == null) {
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(200);
	    	apiResponse.setResponseOrigin("/user/username/{username}, User Lookup by Username");
	    	apiResponse.setResponseText("Username not found.");
	        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(userSearch, HttpStatus.OK);
	    }
	}
	
	@PutMapping(path="/user/{id}")
	public @ResponseBody ResponseEntity<?> updateUserById(@PathVariable long id, @RequestBody User user) {
		User existingUser = userRepository.findById(id).get();
				
		if  (existingUser != null) {
			existingUser.setUsername(user.getUsername());
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			userRepository.save(existingUser);
			
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(202);
	    	apiResponse.setResponseOrigin("/user/{id}, User Update by ID");
	    	apiResponse.setResponseText("User has been updated.");
			
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
		}
		else {
			
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(400);
	    	apiResponse.setResponseOrigin("/user/{id}, User Update by ID");
	    	apiResponse.setResponseText("User does not exist.");
			
			return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(path="/user/{id}/password")
	public @ResponseBody ResponseEntity<?> updateUserPassById(@PathVariable long id, @RequestBody PasswordChange passReq) {
		User existingUser = userRepository.findById(id).get();
		String dbPassword = existingUser.getPassword();
		String reqPassword = passReq.getOldPassword();
		String newPassword = passReq.getNewPassword();
				
		if  (existingUser != null && reqPassword.equals(dbPassword)) {
			existingUser.setPassword(newPassword);
			userRepository.save(existingUser);
			
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(202);
	    	apiResponse.setResponseOrigin("/user/{id}/Password, Password Update by ID");
	    	apiResponse.setResponseText("Password Updated.");
			
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
		}
		else if (existingUser != null && !reqPassword.equals(dbPassword)) {
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(401);
	    	apiResponse.setResponseOrigin("/user/{id}/Password, Password Update by ID");
	    	apiResponse.setResponseText("Your password is incorrect, please try again.");
			return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
		}
		else {
			
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(400);
	    	apiResponse.setResponseOrigin("/user/{id}, User Update by ID");
	    	apiResponse.setResponseText("User does not exist.");
	    	
			return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(path="/user/{id}")
	public @ResponseBody ResponseEntity<?> deleteUserbyId(@PathVariable long id) {
		User userSearch = userRepository.findById(id).get();
		
		if (userSearch != null) {
			
			userRepository.deleteById(id);
			
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(202);
	    	apiResponse.setResponseOrigin("/user/{id}, Delete User by ID");
	    	apiResponse.setResponseText("User Deleted.");
			
			return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
		}
		else {
			
	    	ApiResponse apiResponse = new ApiResponse();
	    	apiResponse.setResponseCode(400);
	    	apiResponse.setResponseOrigin("/user/{id}, Delete User by ID");
	    	apiResponse.setResponseText("User does not exist.");
			
			return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
		}

	}
}