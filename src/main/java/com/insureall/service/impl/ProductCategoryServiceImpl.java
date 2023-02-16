package com.insureall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insureall.entity.ProductCategoryEntity;
import com.insureall.repository.ProductCategoryRepository;
import com.insureall.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategoryEntity> findByProductCategory() {
		return productCategoryRepository.findAll();
	}
	
}
