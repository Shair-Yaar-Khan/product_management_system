package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.model.Product;

public class ProductDaoImpl implements ProductDao{

	static List<Product> productList = new ArrayList<>();

	@Override
	public void saveProduct(Product product) {
	
		try {
			Connection connection = ConnectionPool.getDataSource().getConnection();
			//PreparedStatement preStmt = null;
			
			String insertProduct = "INSERT INTO product (product_code,product_name,product_description,activation_date,expiry_date) VALUES(?,?,?,?,?)";
			PreparedStatement prepStmt = connection.prepareStatement(insertProduct);
			prepStmt.setString(1,product.getProductCode());
			prepStmt.setString(2,product.getProductName());
			prepStmt.setString(3,product.getProductDescription());
			prepStmt.setDate(4,java.sql.Date.valueOf(product.getActivationDate()));
			prepStmt.setDate(5,java.sql.Date.valueOf(product.getExpiryDate()));
			int rs = prepStmt.executeUpdate();
			
			System.out.println("Product saved successfully");
			connection.close();
			
		}catch(SQLException e)
		{
		e.printStackTrace();	
		}
		
	}
}
