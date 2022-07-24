package com.exam.examportal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.entity.portal.Category;
import com.exam.examportal.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<?> addCategory(@RequestBody Category category){
		Category categoryInputed = this.categoryService.addCategory(category);
		return new ResponseEntity<> (categoryInputed,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		Set<Category> categories = this.categoryService.getCategories();
		return new ResponseEntity<> (categories,HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getCategory(@PathVariable("categoryId") Long categoryId){
		Category categoryInputed = this.categoryService.getCategory(categoryId);
		return new ResponseEntity<> (categoryInputed,HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateCategory(@RequestBody Category category){
		Category categoryInputed = this.categoryService.updateCategory(category);
		return new ResponseEntity<> (categoryInputed,HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deltedCategory(@PathVariable("categoryId") Long categoryId){
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
