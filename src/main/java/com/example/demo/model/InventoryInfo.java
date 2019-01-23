package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class InventoryInfo {


    private final List<InventoryLineInfo> inventoryLines = new ArrayList<InventoryLineInfo>();
    
    public List<InventoryLineInfo> getInventoryLines() {
    	List<InventoryLineInfo> inventoryActives = new ArrayList<InventoryLineInfo>();
    	for (InventoryLineInfo inventory : inventoryLines) {
    		if (inventory.isActive()) {
    			inventoryActives.add(inventory);
    		}
    	}
        return inventoryActives;
    }
    
    public void addInventory(InventoryLineInfo inventoryLines) {
    	InventoryLineInfo line = this.findLineByCode(inventoryLines.getId());
        if (line == null) {
            line = new InventoryLineInfo();
            this.inventoryLines.add(line);
        }
    }
 
 
    public void updateInventory(String code, int quantity) {
    	InventoryLineInfo line = this.findLineByCode(code);
 
        if (line != null) {
        	//
        }
    }
 
    public void removeInventory(InventoryLineInfo inventoryLines) {
    	InventoryLineInfo line = this.findLineByCode(inventoryLines.getId());
        if (line != null) {
        	line.desactive();
        }
    }
    
    private InventoryLineInfo findLineByCode(String code) {
        for (InventoryLineInfo line : this.inventoryLines) {
            if (line.getInventoryInfo().getId().equals(code)) {
                return line;
            }
        }
        return null;
    }
}
