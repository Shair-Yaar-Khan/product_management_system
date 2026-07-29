package com.iispl.connectionpool;

import java.sql.Connection;

public class TestConnection {
public static void main(String[] args) {
	
	try {
		
		Connection con = ConnectionPool.getDataSource().getConnection();
		
		System.out.println("Connected to Supabase Succesfully..");
		
		con.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
