package com.insureall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="product_category")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryEntity{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 

	@Column(name="category_name")
	private String categoryName; 

	@Column(name="created_date")
	private String createdDate; 

	@Column(name="created_by")
	private String createdBy; 

	@Column(name="updated_date")
	private String updatedDate; 

	@Column(name="updated_by")
	private String updatedBy; 

	@Column(name="status")
	private int status; 

}