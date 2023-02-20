package com.insureall.service;


import com.insureall.entity.CardDetailsEntity;
import com.insureall.model.ApiResponse;
import com.insureall.model.CardDetails;

public interface CardDetailsService {

	ApiResponse saveCardDetails(CardDetails cardDetails);
	
	CardDetailsEntity fetchCardDetailsByUserId(Integer userId);
}
