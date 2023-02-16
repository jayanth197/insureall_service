package com.insureall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insureall.entity.ProductCategoryEntity;
import com.insureall.service.ProductCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class ProductCategoryController {

	private final String className = this.getClass().getName();
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductCategoryEntity>> findAllProductCategories(){
		log.info(className+" Find all product category");
		return new ResponseEntity<>(productCategoryService.findByProductCategory(),HttpStatus.OK);
	}
	
}
