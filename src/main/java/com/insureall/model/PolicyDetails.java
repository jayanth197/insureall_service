package com.insureall.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PolicyDetails {


	private int uId;
	private int policyNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private int zipCode;
	private String purchaseDate;
	private String expirationDate;
	private int status;
	

}

