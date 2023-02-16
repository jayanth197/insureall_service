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
public class User implements Serializable{

	private static final long serialVersionUID = -5231131200386382257L;

	private int uid; 

	private String email; 

	private String password; 

	private int otp; 

	private String firstName; 

	private String lastName; 

	private String phoneNumber; 

	private String country; 

	private String address; 

	private int zipCode; 

	private String createdDate; 

	private String createdBy; 

	private String updatedDate; 

	private String updatedBy; 

	private int status; 

}