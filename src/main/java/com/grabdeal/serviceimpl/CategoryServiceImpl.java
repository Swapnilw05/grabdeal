package com.grabdeal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.grabdeal.entity.Category;
import com.grabdeal.repository.CategoryRepository;
import com.grabdeal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public boolean existCategory(String name) {
		return categoryRepository.existsByName(name);
	}

	@Override
	public boolean deleteCategory(int id) {
		Category category = categoryRepository.findById(id).orElse(null);

		if (!ObjectUtils.isEmpty(category)) {
			categoryRepository.delete(category);
			return true;
		}
		return false;
	}

	@Override
	public Category getCategoryById(int id) {
	
		Category category = categoryRepository.findById(id).orElse(null);
		return category;
	}

}
