package com.grabdeal.service;

import java.util.List;

import com.grabdeal.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public List<Product> getAllProducts();	

	public boolean deleteProduct(int id);
}
