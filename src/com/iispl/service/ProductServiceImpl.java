package com.iispl.service;

import com.iispl.dao.ProductDao;
import com.iispl.dao.ProductDaoImpl;
import com.iispl.model.Product;

public class ProductServiceImpl implements ProductService{

	 private ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

	@Override
	public void deleteProduct(String productCode) {
		productDao.deleteProduct(productCode);
		
	}

}
