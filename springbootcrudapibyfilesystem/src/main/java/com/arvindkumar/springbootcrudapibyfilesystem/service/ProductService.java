package com.arvindkumar.springbootcrudapibyfilesystem.service;

import java.util.List;

import com.arvindkumar.springbootcrudapibyfilesystem.entity.Product;

public interface ProductService {
	    List<Product> getAllProducts();
	    Product getProductById(Long id);
	    void addProduct(Product product);
	    void updateProduct(Product product);
	    void deleteProduct(Long id);
}
