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

import com.insureall.entity.SubscriptionEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.Subscription;
import com.insureall.service.SubscriptionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class SubscriptionController {

	private final String className = this.getClass().getName();

	@Autowired
	private SubscriptionService subscriptionService;

	@PostMapping("/subscription")
	public ResponseEntity<ApiResponse> savePolicyDetails(@RequestBody Subscription subscription) {
		log.info(className+" Save Card Details request");
		return new ResponseEntity<>(subscriptionService.saveSubscriptionDetails(subscription),HttpStatus.OK);
	}

	@GetMapping("/subscription/{userId}")
	public ResponseEntity<SubscriptionEntity> findByMemberId(@PathVariable Integer userId){
		return new ResponseEntity<>(subscriptionService.fetchSubscriptionByUserId(userId),HttpStatus.OK);
	}

}
