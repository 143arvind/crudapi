package com.arvindkumar.springbootcrudapibyfilesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arvindkumar.springbootcrudapibyfilesystem.entity.Product;
import com.arvindkumar.springbootcrudapibyfilesystem.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
        return productRepository.findAll();

	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.update(product);
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.delete(id);
	}

}
