package com.insureall.service;

import com.insureall.entity.CardDetailsEntity;
import com.insureall.entity.PolicyDetailsEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.PolicyDetails;

public interface PolicyDetailsService {

	ApiResponse savePolicyInfo(PolicyDetails policyDetails);

	PolicyDetailsEntity fetchPolicyDetailsByUserId(Integer userId);
}

