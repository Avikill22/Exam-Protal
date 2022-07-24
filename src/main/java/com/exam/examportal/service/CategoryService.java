package com.exam.examportal.service;

import java.util.Set;

import com.exam.examportal.entity.portal.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long categoryId);
	public void deleteCategory(Long categoryId);
}
