package com.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class Product {
	private String ProductName;
	private double ProductPrice;
	private String ProductCategory;

	public Product(String ProductName, double ProductPrice, String ProductCategory) {
		this.ProductName = ProductName;
		this.ProductPrice = ProductPrice;
		this.ProductCategory = ProductCategory;
	}

	public String getProductName() {
		return ProductName;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public String getProductCategory() {
		return ProductCategory;
	}

	@Override
	public String toString() {
		return "Product{name=" + ProductName + ", price=" + ProductPrice + ", category=" + ProductCategory + "}";
	}
}

class ProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		int ProductComparison = product1.getProductName().compareTo(product2.getProductName());
		if (ProductComparison == 0) {
			return Double.compare(product1.getProductPrice() , (product2.getProductPrice()));
		}
		return ProductComparison;
	}

}

public class OnlineMarketplaces {
	public static void main(String[] args) {
		ProductComparator ProductComparator = new ProductComparator();

		PriorityQueue<Product> ProductQueue = new PriorityQueue<>(ProductComparator);

		ProductQueue.add(new Product("Bed", 20000.0, "Furniture" ));
		ProductQueue.add(new Product("Sofa", 15000.0, "Furniture"));
		ProductQueue.add(new Product("Home Temple", 10000.0, "Furniture"));
		ProductQueue.add(new Product("Coffee Tables", 5000.0, "Furniture"));
		ProductQueue.add(new Product("Wardrobes", 12000.0, "Furniture"));

		System.out.println("Items sorted by name and price:");
		while (!ProductQueue.isEmpty()) {
			System.out.println(ProductQueue.poll());
		}
	}
}
