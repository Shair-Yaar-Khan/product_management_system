package com.iispl.dao;

import java.util.List;

import com.iispl.model.Product;

public interface ProductDao {

	public void saveProduct(Product product);
	public List<Product> listAllProducts();
}
