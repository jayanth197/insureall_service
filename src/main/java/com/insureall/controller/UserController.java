package com.insureall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insureall.entity.UserEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.User;
import com.insureall.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value="/user/create") 
	public ResponseEntity<ApiResponse>saveUser(HttpServletRequest request, @RequestBody User user) {
		ApiResponse apiResponse = null; 
		apiResponse = userService.saveUser(user); 
		return new ResponseEntity<>(apiResponse,HttpStatus.OK); 
	}
	
	@GetMapping(value="/getall") 
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		log.info("UserController | getAllUsers : Request received");
		List<UserEntity> lstUsers=null; 
		lstUsers = userService.findAll(); 
		log.info("UserController | getAllUsers : Response - "+lstUsers.size());
		return new ResponseEntity<>(lstUsers,HttpStatus.OK); 
	}

	@PostMapping(value="/login") 
	public ResponseEntity<ApiResponse>login(HttpServletRequest request,@RequestBody User user) {
		ApiResponse apiResponse = null; 
		apiResponse = userService.login(user); 
		return new ResponseEntity<>(apiResponse,HttpStatus.OK); 
	}

	@PostMapping(value="/verifyotp") 
	public ResponseEntity<ApiResponse> verifyOtp(@RequestBody User user) {
		ApiResponse apiResponse = null; 
		apiResponse = userService.verifyOtp(user); 
		return new ResponseEntity<>(apiResponse,HttpStatus.OK); 
	}

	//getById 
	@GetMapping(value="/{uId}")  
	private ApiResponse getUserById(@PathVariable("uId") int uId)   
	{  
		return userService.getUserById(uId);  
	}  

	@PutMapping(value="/update") 
	public ResponseEntity<ApiResponse>saveUser(@RequestBody User user) {
		ApiResponse apiResponse = null; 
		apiResponse = userService.saveOrUpdate(user); 
		return new ResponseEntity<>(apiResponse,HttpStatus.OK); 	
	}
}		
