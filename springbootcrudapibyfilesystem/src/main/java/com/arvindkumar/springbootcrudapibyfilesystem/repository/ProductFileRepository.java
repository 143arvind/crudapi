package com.arvindkumar.springbootcrudapibyfilesystem.repository;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.arvindkumar.springbootcrudapibyfilesystem.entity.Product;
@Repository
public class ProductFileRepository implements ProductRepository {
	
	private static final String FILE_PATH = "products.dat";
	File file=new File(FILE_PATH);

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Product product = (Product) ois.readObject();
                    products.add(product);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Product product = (Product) ois.readObject();
                    if (product.getId().equals(id)) {
                        return product;
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		 List<Product> products = findAll();
	        long maxId = products.stream()
	                .mapToLong(Product::getId)
	                .max()
	                .orElse(0L);
	        product.setId(maxId + 1); // Auto-generate ID (replace with your own ID generation logic if needed)
	        products.add(product);
	        saveAll(products);
	}

	@Override
	public void update(Product productToUpdate) {
		// TODO Auto-generated method stub
		List<Product> products = findAll();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getId().equals(productToUpdate.getId())) {
                products.set(i, productToUpdate);
                break;
            }
        }
        saveAll(products);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		List<Product> products = findAll();
        products.removeIf(product -> product.getId().equals(id));
        saveAll(products);
	}
	 private void saveAll(List<Product> products) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
	            for (Product product : products) {
	                oos.writeObject(product);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
