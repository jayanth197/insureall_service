package com.insureall.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDetails implements Serializable{

	private static final long serialVersionUID = -7233871499403089766L;

	private int id;
	
	private int userId;
	
	private String cardName; 

	private int cardNumber; 

	private String cvv; 

	private String expiryDate; 

	private String createdDate; 

	private String createdBy; 

	private String updatedDate; 

	private String updatedBy; 

	private int status; 

}