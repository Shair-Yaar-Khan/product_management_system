package com.iispl.service;

import java.util.List;

import com.iispl.dao.ProductDao;
import com.iispl.dao.ProductDaoImpl;
import com.iispl.model.Product;

public class ProductServiceImpl implements ProductService{

	 private ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}
// feature/DeleteProduct

	@Override
	public void deleteProduct(String productCode) {
		productDao.deleteProduct(productCode);
		
	}

	
	@Override
    public List<Product> listAllProducts() {
        return productDao.listAllProducts();
    }
	//getProduct
	@Override
	public Product getProduct(String productCode) {
		return productDao.getProduct(productCode);
	} 
}
