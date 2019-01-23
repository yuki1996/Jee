package com.example.demo.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.InventoryDAO;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;
import com.example.demo.model.InventoryInfo;
import com.example.demo.model.InventoryLineInfo;
import com.example.demo.model.ProductInfo;

@Transactional
public class InventoryDAOImpl implements InventoryDAO {
    @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public Inventory findInventory(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Product.class);
        crit.add(Restrictions.eq("id", id));
        return (Inventory) crit.uniqueResult();
    }
 
    @Override
    public InventoryLineInfo findInventoryInfo(String code) {
    	Inventory inventory = this.findInventory(code);
        if (inventory == null) {
            return null;
        }
        //TODO
        return new InventoryLineInfo();
    }
 
    @Override
    public void save(InventoryLineInfo inventoryLineInfo) {
        String code = inventoryLineInfo.getId();
        Inventory inventory = null;
 
        boolean isNew = false;
        if (code != null) {
        	inventory = this.findInventory(code);
        }
        if (inventory == null) {
            isNew = true;
            inventory = new Inventory();
        }
        inventory.setId(code);
        //TODO
        if (isNew) {
            this.sessionFactory.getCurrentSession().persist(inventory);
        }
        
        // If error in DB, Exceptions will be thrown out immediately
        this.sessionFactory.getCurrentSession().flush();
    }
}
