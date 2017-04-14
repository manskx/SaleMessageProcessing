package com.manskx.salemessageprocessing.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private List<Sale> sales;

	public Product() {
		this.sales = new ArrayList<Sale>();
	}

	public void addSaleToProduct(Sale sale) {
		sales.add(sale);
	}

	public int getTotalValue() {
		int totalSales = 0;
		for (Sale sale : sales) {
			totalSales += sale.getValue();
		}
		return totalSales;
	}

	public int getNumberOfSales() {
		return sales.size();
	}

	public void addMultiplesSalesToProduct(List<Sale> sales) {
		this.sales.addAll(sales);
	}

	public List<Sale> getSales() {
		return sales;
	}
}
