package com.iispl.service;

import java.util.List;

import com.iispl.model.Product;

public interface ProductService {

	public void saveProduct(Product product);
	// feature/DeleteProduct
	void deleteProduct(String productCode);
	//feature/getProduct
	public Product getProduct(String productCode);
	//list all products
	public List<Product> listAllProducts();
}
