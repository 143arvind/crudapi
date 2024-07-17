package com.arvindkumar.springbootcrudapibyfilesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvindkumar.springbootcrudapibyfilesystem.entity.Product;
import com.arvindkumar.springbootcrudapibyfilesystem.service.ProductService;
/*
 * post http://localhost:8081/products/saveproduct
 * get  http://localhost:8081/products/getallproduct
 * get  http://localhost:8081/products/getproductbyid/
 * update  http://localhost:8081/products/updateproductbyid/
 * delete  http://localhost:8081/products/deleteproductbyid/
 * */

@RestController
@RequestMapping("/products")
public class ProductController {
	   private final ProductService productService;

	    @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }
	    @GetMapping("/getallproduct")
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }
	    @GetMapping("/getproductbyid/{id}")
	    public Product getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @PostMapping("/saveproduct")
	    public void addProduct(@RequestBody Product product) {
	        productService.addProduct(product);
	    }
	    @PutMapping("/updateproductbyid/{id}")
	    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        product.setId(id);
	        productService.updateProduct(product);
	    }

	    @DeleteMapping("/deleteproductbyid/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
}
