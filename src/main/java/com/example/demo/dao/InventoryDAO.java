package com.example.demo.dao;

import com.example.demo.entity.Inventory;
import com.example.demo.model.InventoryLineInfo;

public interface InventoryDAO {

    public Inventory findInventory(String code);
    public InventoryLineInfo findInventoryInfo(String code) ;
    public void save(InventoryLineInfo inventoryLineInfo);
}
