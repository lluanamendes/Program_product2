package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.Usedproduct;
import ui.ProductUI;

public class Main {

	public static void main(String[] args) {
		ProductUI.launchApp();
		Scanner sc= new Scanner(System.in);
		DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List <Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products:");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.println("Product #"+(i+1)+" data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char op=sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name=sc.nextLine();
			System.out.print("Price: ");
			double price=sc.nextDouble();
			
			if(op=='i') {
				System.out.print("Customs fee: ");
				double customs=sc.nextDouble();
				ImportedProduct imp = new ImportedProduct(name, price, customs);
				list.add(imp);
				
			} else if (op=='u') {
				System.out.print("Manufactured date(DD/MM/YYYY): ");
				String manufacture=sc.next();
				LocalDate data = LocalDate.parse(manufacture, fmt); 
				Usedproduct used = new Usedproduct(name, price, data);
				list.add(used);
			} else {
				Product product = new Product(name, price);
				list.add(product);
			}	
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		sc.close();

	}

}
