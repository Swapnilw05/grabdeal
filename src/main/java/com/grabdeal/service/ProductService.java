package com.grabdeal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.grabdeal.entity.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public List<Product> getAllProducts();	

	public boolean deleteProduct(int id);

	public Product getProductById(int id);

	public Product updateProduct(Product product, MultipartFile file);
}
