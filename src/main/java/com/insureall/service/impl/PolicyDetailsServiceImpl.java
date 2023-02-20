package com.insureall.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insureall.entity.PolicyDetailsEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.PolicyDetails;
import com.insureall.repository.PolicyDetailsRepository;
import com.insureall.service.PolicyDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyDetailsServiceImpl implements PolicyDetailsService{
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PolicyDetailsRepository policyDetailsRepository;
	 
	@Override
	public ApiResponse savePolicyInfo(PolicyDetails policyDetails) {
		PolicyDetailsEntity policyDetailsEntity = modelMapper.map(policyDetails, PolicyDetailsEntity.class);
		policyDetailsRepository.save(policyDetailsEntity);
		return ApiResponse.builder().statusCode("0000").statusMessage("Policy Details Saved Successfully").build();
	}

	@Override
	public PolicyDetailsEntity fetchPolicyDetailsByUserId(Integer userId) {
		
		PolicyDetailsEntity policyDetailsEntity = null;
		
		Optional<PolicyDetailsEntity> optPolicyDetailsEntity = policyDetailsRepository.findByUid(userId);
		
		if(optPolicyDetailsEntity.isPresent()) {
			policyDetailsEntity = optPolicyDetailsEntity.get();
		}
		return policyDetailsEntity;
	}

	
}
