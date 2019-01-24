package com.example.demo.dao;

import com.example.demo.entity.InventoryAndProduct;
import com.example.demo.entity.Product;
import com.example.demo.model.InventoryAndProductInfo;
import com.example.demo.model.PaginationResult;
import com.example.demo.model.ProductInfo;

public interface InventoryAndProductDAO {
	
	
    public InventoryAndProduct findInventoryAndProduct(String code);
    public InventoryAndProductInfo findInventoryAndProductInfo(String code) ;
    

    public PaginationResult<InventoryAndProductInfo> queryInventoryAndProducts(int page, int maxResult,
            int maxNavigationPage, String id);

    public void save(InventoryAndProductInfo InventoryAndProductInfo);
    
	public void delete(InventoryAndProductInfo InventoryAndProductInfo);

}
