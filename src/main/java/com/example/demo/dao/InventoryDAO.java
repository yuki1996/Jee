package com.example.demo.dao;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.User;
import com.example.demo.model.InventoryInfo;
import com.example.demo.model.PaginationResult;
import com.example.demo.model.UserInfo;

public interface InventoryDAO {

    public Inventory findInventory(String code);
    public InventoryInfo findInventoryInfo(String code) ;
    public void save(InventoryInfo InventoryInfo);
    public void delete(InventoryInfo InventoryInfo);
	public PaginationResult<InventoryInfo> queryInventories(int page, int maxResult, int maxNavigationPage, String likeName);
	public PaginationResult<InventoryInfo> queryInventories(int page, int maxResult, int maxNavigationPage);
	public void open(String id);
	public void close(String id);
}
