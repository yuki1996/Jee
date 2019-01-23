package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class InventoryLineInfo  {
	
    private UserInfo userInfo;
    private String id;
    private boolean active;
    private final List<InventoryAndProductInfo> inventoryAndProductLines = new ArrayList<InventoryAndProductInfo>();
    
    public UserInfo getUserInfo() {
        return userInfo;
    }
 
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    public List<InventoryAndProductInfo> getInventoryAndProductLines() {
        return this.inventoryAndProductLines;
    }
    
    public void addQuantityOfProduct(InventoryAndProductInfo inventoryAndProductInfo, int quantity) {
    	InventoryAndProductInfo line = this.findLineByCode(inventoryAndProductInfo.getId());
 
        if (line == null) {
            line = new InventoryAndProductInfo();
            line.setQuantity(quantity);
            line.setInventoryAndProductInfo(inventoryAndProductInfo);
            this.inventoryAndProductLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.inventoryAndProductLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }

	public boolean isActive() {
		return active;
	}

	public String getId() {
		return this.id;
	}

	public void desactive() {
		this.active = false;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public InventoryLineInfo getInventoryInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
    private InventoryAndProductInfo findLineByCode(String code) {
        for (InventoryAndProductInfo line : this.inventoryAndProductLines) {
            if (line.getId().equals(code)) {
                return line;
            }
        }
        return null;
    }
}
