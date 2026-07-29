package com.iispl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

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
// feature/DeleteProduct

	@Override
	public void deleteProduct(String productCode) {
		Connection connection=null;
		PreparedStatement prepStmt=null;
		String deleteSql="Delete from product where product_code=?";
		try {
			DataSource ds=ConnectionPool.getDataSource();
			connection=ds.getConnection();
			prepStmt=connection.prepareStatement(deleteSql);
			prepStmt.setString(1, productCode);
			int result=prepStmt.executeUpdate();
			 if(result>0) {
				 System.out.println( result + " ROW Deleted");
			 }
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
//	Add listAllProduct
	
	@Override
    public List<Product> listAllProducts() {

        List<Product> productList = new ArrayList<>();

        try  {
        	
        	Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                productList.add(new Product(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4).toLocalDate(),
                        resultSet.getDate(5).toLocalDate()));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

	@Override
    public Product getProduct(String productCode) {

        Product product = null;

        String sql = "SELECT * FROM product WHERE product_code=?";

        try {

            DataSource ds = ConnectionPool.getDataSource();
            Connection connection = ds.getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, productCode);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                product = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate(),
                        rs.getDate(5).toLocalDate());

            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
