package com.infotech.org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PromotionEngine {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		List<Product> products = new ArrayList<Product>();
		System.out.println("Please Enter Number of Products for order");
		
		while(!sc1.hasNextInt()){
			System.out.println("Cool dear:)! Please enter correct int input");
			sc1.next();
		}
		int numberOfProducts = sc1.nextInt();
        
        for (int i = 0; i < numberOfProducts; i++){
        	System.out.println("enter the type of product: A,B,C or D");
            String type = sc1.next();
            System.out.println("Do you wish to add number of Quantity of '" +type+ "' Yes/No");
            int quantity = 1;
            if("Yes".equalsIgnoreCase(sc2.next())){
               System.out.println("Please Enter Number of Quantity of '" +type + "' Product");
               quantity = sc2.nextInt();	
            }
            Product p = new Product(type,quantity);
            products.add(p);
        }
        int totalPrice = GetTotalPrice(products);
        System.out.println("Total Amount of Product is = "+totalPrice);
    }

    private static int GetTotalPrice(List<Product> products) {
        int counterofA = 0;
        int priceofA = 50;
        int counterofB = 0;
        int priceofB = 30;
        int counterofC = 0;
        int priceofC = 20;
        int counterofD = 0;
        int priceofD = 15;
        
        for(Product pr : products){
	        if ("A".equalsIgnoreCase(pr.id)){
				counterofA = pr.getQuantity();
	        }else if ("B".equalsIgnoreCase(pr.id)){
				counterofB = pr.getQuantity();
	        }else if ("C".equalsIgnoreCase(pr.id)){
				counterofC = pr.getQuantity() ;
	        }else if ("D".equalsIgnoreCase(pr.id)){
				counterofD = pr.getQuantity();
	        }
        }
        
        int totalPriceofA = (counterofA / 3) * 130 + (counterofA % 3 * priceofA);
        int totalPriceofB = (counterofB / 2) * 45 + (counterofB % 2 * priceofB);
        int totalPriceofC = (counterofC * priceofC);
        int totalPriceofD = (counterofD * priceofD);
        return totalPriceofA + totalPriceofB + totalPriceofC + totalPriceofD;
    }
}

class Product {
	
    public String id ;
    public Double price;
    public int quantity;

    public Product(String id,int quantity) {
        this.id = id;
        this.quantity = quantity;
        switch (id){
            case "A":  this.price = 50d;
                break;
            case "B": this.price = 30d;
                break;
            case "C": this.price = 20d;
                break;
            case "D": this.price = 2015d;
                break;
        }
    }

	public String getId() {
		return id;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}

