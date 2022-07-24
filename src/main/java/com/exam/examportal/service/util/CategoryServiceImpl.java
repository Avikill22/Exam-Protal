package com.exam.examportal.service.util;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.portal.Category;
import com.exam.examportal.repository.CategoryRepository;
import com.exam.examportal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepsitory;

	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepsitory.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepsitory.save(category);
	}

	@Override
	public Set<Category> getCategories() {
//		List<Category> categories = this.categoryRepsitory.findAll();
//		Set<Category> findAll = categories.stream().collect(Collectors.toSet());
		return new LinkedHashSet<>(this.categoryRepsitory.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		return this.categoryRepsitory.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		this.categoryRepsitory.deleteById(categoryId);
	}

}
