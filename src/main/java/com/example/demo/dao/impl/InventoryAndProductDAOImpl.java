package com.example.demo.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.InventoryAndProductDAO;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.InventoryAndProduct;
import com.example.demo.model.InventoryAndProductInfo;
import com.example.demo.model.InventoryInfo;
import com.example.demo.model.PaginationResult;

public class InventoryAndProductDAOImpl implements InventoryAndProductDAO  {

    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public InventoryAndProduct findInventoryAndProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(InventoryAndProduct.class);
        crit.add(Restrictions.eq("id", id));
        return (InventoryAndProduct) crit.uniqueResult();
	}

	@Override
	public InventoryAndProductInfo findInventoryAndProductInfo(String code) {
		InventoryAndProduct inventoryAndProduct = this.findInventoryAndProduct(code);
        if (inventoryAndProduct == null) {
            return null;
        }
        return new InventoryAndProductInfo(code, inventoryAndProduct.getQuantity(),
        		inventoryAndProduct.getProduct(), inventoryAndProduct.getInventory());
	}

	@Override
	public PaginationResult<InventoryAndProductInfo> queryInventoryAndProducts(int page, int maxResult,
			int maxNavigationPage, String id) {
		String sql = "Select new " + InventoryAndProductInfo.class.getName() //
                + "(p.id, p.quantity, p.product, p.inventory) " + " from "//
                + InventoryAndProduct.class.getName() + " p";
        
        //
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        return new PaginationResult<InventoryAndProductInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Override
	public void save(InventoryAndProductInfo InventoryAndProductInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(InventoryAndProductInfo InventoryAndProductInfo) {
		// TODO Auto-generated method stub
		
	}

}
