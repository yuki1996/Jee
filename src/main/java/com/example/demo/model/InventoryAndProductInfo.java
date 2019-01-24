package com.example.demo.model;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;

public class InventoryAndProductInfo {

	private int quantity;
	private String id;
	private Product product;
	private Inventory inventory;
	
	public InventoryAndProductInfo() {
		
	}
	
	public InventoryAndProductInfo(String id, int quantity, Product product,
			Inventory inventory) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.inventory = inventory;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int qqty) {
		this.quantity = qqty;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	public void setInventoryAndProductInfo(InventoryAndProductInfo inventoryAndProductInfo) {
		// TODO Auto-generated method stub
		
	}





}
