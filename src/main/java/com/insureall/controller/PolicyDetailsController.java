package com.insureall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insureall.entity.PolicyDetailsEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.PolicyDetails;
import com.insureall.service.PolicyDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class PolicyDetailsController {

	private final String className = this.getClass().getName();
	
	@Autowired
	private PolicyDetailsService policyDetailsService;
	
	@PostMapping("/policy")
	public ResponseEntity<ApiResponse> savePolicyDetails(@RequestBody PolicyDetails policyDetails) {
		log.info(className+" Save Card Details request");
		return new ResponseEntity<>(policyDetailsService.savePolicyInfo(policyDetails),HttpStatus.OK);
	}
	
	@GetMapping("/policy/{userId}")
	public ResponseEntity<PolicyDetailsEntity> findByMemberId(@PathVariable Integer userId){
		return new ResponseEntity<>(policyDetailsService.fetchPolicyDetailsByUserId(userId),HttpStatus.OK);
	}
	
}
