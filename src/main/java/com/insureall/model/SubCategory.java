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
public class SubCategory implements Serializable{

	private static final long serialVersionUID = 8616425905787075827L;

	private int id; 

	private int categoryId; 

	private String subCategoryName; 

	private String createdDate; 

	private String createdBy; 

	private String updatedDate; 

	private String updatedBy; 

	private int status; 

}