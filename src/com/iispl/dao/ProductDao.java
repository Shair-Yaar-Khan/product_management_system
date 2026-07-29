package com.iispl.dao;

import java.util.List;

import com.iispl.model.Product;

public interface ProductDao {

	public void saveProduct(Product product);
// feature/DeleteProduct

	public void deleteProduct(String productCode);
	
	public Product getProduct(String productCode);
//	for Show product list
	public List<Product> listAllProducts();

}
