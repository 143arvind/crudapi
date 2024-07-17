package com.arvindkumar.springbootcrudapibyfilesystem.repository;

import java.util.List;

import com.arvindkumar.springbootcrudapibyfilesystem.entity.Product;

public interface ProductRepository {
	List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void update(Product product);
    void delete(Long id);
}
