package com.insureall.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insureall.entity.SubscriptionEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.Subscription;
import com.insureall.repository.SubscriptionRepository;
import com.insureall.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{


	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse saveSubscriptionDetails(Subscription subscription) {
		SubscriptionEntity subscriptionEntity = modelMapper.map(subscription, SubscriptionEntity.class);
		subscriptionRepository.save(subscriptionEntity);
		return ApiResponse.builder().statusCode("0000").statusMessage("Card Details Saved Successfully").build();
	}

	@Override
	public SubscriptionEntity fetchSubscriptionByUserId(Integer userId) {
		SubscriptionEntity subscriptionEntity = null;
		Optional<SubscriptionEntity> optionalSubscriptionEntity = subscriptionRepository.findByCustomerId(userId);
		if(optionalSubscriptionEntity.isPresent()) {
			subscriptionEntity = optionalSubscriptionEntity.get();
		}
		return subscriptionEntity;
	}
}
