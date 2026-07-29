package com.iispl.connectionpool;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {

	private static ComboPooledDataSource dataSource;
	
	static
	{
		try {
			
			InputStream inputStream = new FileInputStream("resources/db.properties");
			
			Properties property = new Properties();
			
			property.load(inputStream);
			
			dataSource.setDriverClass(property.getProperty("DRIVER_CLASS"));
			dataSource.setJdbcUrl(property.getProperty("CONNECTION_STRING"));
			dataSource.setUser(property.getProperty("USERNAME"));
			dataSource.setPassword(property.getProperty("PASSWORD"));
			
		}catch(IOException | PropertyVetoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public javax.sql.DataSource getDataSource(){
		return dataSource;
	}
}
