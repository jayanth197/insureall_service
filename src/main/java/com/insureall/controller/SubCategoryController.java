package com.insureall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insureall.entity.SubCategoryEntity;
import com.insureall.service.SubCategoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1")
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;
	
	@GetMapping("/subcategory/{userId}")
	public ResponseEntity<List<SubCategoryEntity>> findByMemberId(@PathVariable Integer categoryId){
		return new ResponseEntity<>(subCategoryService.findSubCategoryByCategoryId(categoryId) ,HttpStatus.OK);
	}
}
