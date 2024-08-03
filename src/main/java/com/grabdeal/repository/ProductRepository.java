package com.grabdeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grabdeal.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
