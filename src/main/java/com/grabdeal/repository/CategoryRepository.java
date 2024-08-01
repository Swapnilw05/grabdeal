package com.grabdeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabdeal.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	public boolean existsByName(String name);
}
