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
@Table(name="subscription")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionEntity{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; 

	@Column(name="customer_id")
	private String customerId; 

	@Column(name="description")
	private String description; 

	@Column(name="expiry_date")
	private String expiryDate; 

	@Column(name="package_name")
	private String packageName; 

	@Column(name="package_price")
	private String packagePrice; 

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