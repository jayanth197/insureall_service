package com.insureall.service;

import com.insureall.entity.SubscriptionEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.Subscription;

public interface SubscriptionService {

	ApiResponse saveSubscriptionDetails(Subscription subscription);
	
	SubscriptionEntity fetchSubscriptionByUserId(Integer userId);
}
