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
public class ProductCategory implements Serializable{
 
	private static final long serialVersionUID = 4881597628682048921L;

	private int id; 

	private String categoryName; 

	private String createdDate; 

	private String createdBy; 

	private String updatedDate; 

	private String updatedBy; 

	private int status; 

}