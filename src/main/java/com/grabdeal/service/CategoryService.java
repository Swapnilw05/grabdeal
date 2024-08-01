package com.grabdeal.service;

import java.util.List;

import com.grabdeal.entity.Category;

public interface CategoryService {

	public Category saveCategory(Category category);

	public List<Category> getAllCategory();

	public boolean existCategory(String name);

	public boolean deleteCategory(int id);

	public Category getCategoryById(int id);
}
