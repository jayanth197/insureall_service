package com.insureall.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insureall.entity.SubCategoryEntity;
import com.insureall.repository.SubCategoryRepository;
import com.insureall.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Override
	public List<SubCategoryEntity> findSubCategoryByCategoryId(Integer categoryId) {
		
		List<SubCategoryEntity> lstSubCategoryEntities = null;
		
		Optional<List<SubCategoryEntity>> optLstSubCategory =  subCategoryRepository.findByCategoryId(categoryId);
		
		if(optLstSubCategory.isPresent()) {
			lstSubCategoryEntities = optLstSubCategory.get();
		}
		
		return lstSubCategoryEntities;
	}

}
