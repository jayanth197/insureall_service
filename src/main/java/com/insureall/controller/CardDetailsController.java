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

import com.insureall.entity.CardDetailsEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.CardDetails;
import com.insureall.service.CardDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class CardDetailsController {

	private final String className = this.getClass().getName();
	
	@Autowired
	private CardDetailsService cardDetailsService;
	
	@PostMapping("/card")
	public ResponseEntity<ApiResponse> saveCardDetails(@RequestBody CardDetails cardDetails) {
		log.info(className+" Save Card Details request");
		return new ResponseEntity<>(cardDetailsService.saveCardDetails(cardDetails),HttpStatus.OK);
	}
	
	@GetMapping("/card/{userId}")
	public ResponseEntity<CardDetailsEntity> findByMemberId(@PathVariable Integer userId){
		return new ResponseEntity<>(cardDetailsService.fetchCardDetailsByUserId(userId),HttpStatus.OK);
	}
	
}
