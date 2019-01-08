package com.sushant.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushant.model.User;
import com.sushant.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Map<String,String>errors;
	
	@PostMapping("/createuser")
	public ResponseEntity<Object> createUser(@RequestBody @Valid User user,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			errors=new HashMap<>();
			for(FieldError error:bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors,HttpStatus.NOT_ACCEPTABLE);
			
		}
		
		User u=userService.FindByEmail(user.getEmail());
		if(u!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
	}
	

}
