package com.insureall.service;

import java.util.List;

import com.insureall.entity.SubCategoryEntity;

public interface SubCategoryService {

	List<SubCategoryEntity> findSubCategoryByCategoryId(Integer categoryId);
}
