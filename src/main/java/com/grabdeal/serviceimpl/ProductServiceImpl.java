package com.grabdeal.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.grabdeal.entity.Product;
import com.grabdeal.repository.ProductRepository;
import com.grabdeal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	private Product save;
	private Optional<Product> byId;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public boolean deleteProduct(int id) {

		Product product = productRepository.findById(id).orElse(null);

		if (!ObjectUtils.isEmpty(product)) {
			productRepository.delete(product);
			return true;
		}
		return false;
	}

	@Override
	public Product getProductById(int id) {
		Product product = productRepository.findById(id).orElse(null);
		return product;
	}

	@Override
	public Product updateProduct(Product product, MultipartFile image){
		Product dbProduct = getProductById(product.getId());

		String imageName = image.isEmpty() ? dbProduct.getImage() : image.getOriginalFilename();

		dbProduct.setTitle(product.getTitle());
		dbProduct.setDescription(product.getDescription());
		dbProduct.setCategory(product.getCategory());
		dbProduct.setPrice(product.getPrice());
		dbProduct.setStock(product.getStock());
		dbProduct.setImage(imageName);

		Product updateProduct = productRepository.save(dbProduct);

		if (!ObjectUtils.isEmpty(updateProduct)) {
			if (!image.isEmpty()) {
				try {
					File saveFile = new ClassPathResource("static/img").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + "product_img" + File.separator 
						+ image.getOriginalFilename());

			System.out.println(path);

			Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				
		} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}

			return product;
		}
		return null;
	}

}
