package com.iispl.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.iispl.model.Product;
import com.iispl.service.ProductService;
import com.iispl.service.ProductServiceImpl;

public class ProductApplication {

private static ProductService productService=new ProductServiceImpl();
	
	static char gotochar;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
	do {
		System.out.println("1.List All Products");
		System.out.println("2.Save Product");
		System.out.println("3.get Product");
		System.out.println("4.delete Product");
		System.out.println("------------------------");
		System.out.println("ENTER CHOICE:");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			listAllProducts();
			break;
		case 2:
			saveProduct();
			break;
		case 3:
			getProduct();
			break;
		case 4:
			deleteProduct();
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		
		}
		System.out.println("-----------------------");
		System.out.println("Go to Main Menu(y/n)");
		System.out.println("------------------------");
		gotochar=sc.next().charAt(0);
		
	}while(gotochar == 'y' || gotochar == 'Y');
	
	System.out.println("Program Terminated");
	}

	private static void deleteProduct() {
		System.out.println("Enter Product Code:");
		String productCode=sc.nextLine();
		productService.deleteProduct( productCode);
		
	}

	private static void getProduct() {
		System.out.println("Enter Product Code:");
		
		String productCode=sc.nextLine();
	
		Product product = productService.getProduct(productCode);
		if(product != null) {
		System.out.printf("%-12s %-15s %-35s %-18s %-10s%n","Product Code","Product Name","Product Description","Activation Date","Expiry Date" );
		System.out.println();
		System.out.printf("%-13s %-15s %-35s %-18s %-10s%n",product.getProductCode(),product.getProductName(),product.getProductDescription(),product.getActivationDate(),product.getExpiryDate());
		}else {
			System.out.println("Product Not found");
		}
	}

	private static void saveProduct() {
		System.out.println("Enter Product Code:");
		
		String productCode=sc.nextLine();
		
		
		
		System.out.println("Enter Product Name:");
		String productName=sc.nextLine();
		System.out.println("Enter Product Description:");
		String productDescription=sc.nextLine();
		
		Product product=new Product(productCode,productName,productDescription,LocalDate.now(),LocalDate.now());
		productService.saveProduct(product);
		
	}

	private static void listAllProducts() {
		List<Product>productList = productService.listAllProducts();
		System.out.printf("%-14s %-15s %-30s %-18s %-10s%n","Product Code","Product Name","Product Description","Activation Date","Expiry Date" );
		System.out.println();
		for(Product product:productList)
			System.out.printf("%-14s %-15s %-30s %-18s %-10s%n",product.getProductCode(),product.getProductName(),product.getProductDescription(),product.getActivationDate(),product.getExpiryDate());
	}

}
