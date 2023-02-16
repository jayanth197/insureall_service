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
@Table(name="user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="email")
	private String email; 

	@Column(name="password")
	private String password; 

	@Column(name="otp")
	private int otp; 

	@Column(name="first_name")
	private String firstName; 

	@Column(name="last_name")
	private String lastName; 

	@Column(name="phone_number")
	private String phoneNumber; 

	@Column(name="country")
	private String country; 

	@Column(name="address")
	private String address; 

	@Column(name="zip_code")
	private int zipCode; 

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