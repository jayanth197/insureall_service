package com.insureall.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insureall.entity.CardDetailsEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.CardDetails;
import com.insureall.repository.CardDetailsRepository;
import com.insureall.service.CardDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CardDetailsServiceImpl implements CardDetailsService{


	@Autowired
	private CardDetailsRepository cardDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse saveCardDetails(CardDetails cardDetails) {
		CardDetailsEntity cardDetailsEntity = modelMapper.map(cardDetails, CardDetailsEntity.class);
		cardDetailsRepository.save(cardDetailsEntity);
		return ApiResponse.builder().statusCode("0000").statusMessage("Card Details Saved Successfully").build();
	}

	@Override
	public CardDetailsEntity fetchCardDetailsByUserId(Integer userId) {
		CardDetailsEntity cardDetailsEntity = null;
		Optional<CardDetailsEntity> optCardDetailsEntity = cardDetailsRepository.findById(userId);
		if(optCardDetailsEntity.isPresent()) {
			cardDetailsEntity = optCardDetailsEntity.get();
		}
		return cardDetailsEntity;
	}
}
