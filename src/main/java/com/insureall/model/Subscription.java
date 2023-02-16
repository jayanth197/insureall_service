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
public class Subscription implements Serializable{

	private static final long serialVersionUID = 6381702586692684379L;

	private String suscriptionId; 

	private String customerId; 

	private String description; 

	private String expiryDate; 

	private String packageName; 

	private String packagePrice; 

	private String createdDate; 

	private String createdBy; 

	private String updatedDate; 

	private String updatedBy; 

	private int status; 

}