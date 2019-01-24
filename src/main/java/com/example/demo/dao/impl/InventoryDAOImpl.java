package com.example.demo.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.InventoryDAO;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.model.InventoryInfo;
import com.example.demo.model.PaginationResult;
import com.example.demo.model.ProductInfo;
import com.example.demo.model.UserInfo;

@Transactional
public class InventoryDAOImpl implements InventoryDAO {
    @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public Inventory findInventory(String id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Inventory.class);
        crit.add(Restrictions.eq("id", id));
        return (Inventory) crit.uniqueResult();
    }
 
    @Override
    public InventoryInfo findInventoryInfo(String code) {
    	Inventory inventory = this.findInventory(code);
        if (inventory == null) {
            return null;
        }
        return new InventoryInfo(code, inventory.getCreateDate(),  inventory.getEtat(),  
        		 inventory.getUser());
    }

	@Override
	public void save(InventoryInfo inventoryInfo) {
		String code = inventoryInfo.getId();
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

	@Override
	public void delete(InventoryInfo InventoryInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaginationResult<InventoryInfo> queryInventories(int page, int maxResult, int maxNavigationPage,
			String likeName) {
		String sql = "Select new " + InventoryInfo.class.getName() //
                + "(p.id,p.createDate, p.etat,p.user.id, p.user.email, p.user.password, p.user.userRole) " + " from "//
                + Inventory.class.getName() + " p";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.id) like :likeName ";
        }
        //
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        return new PaginationResult<InventoryInfo>(query, page, maxResult, maxNavigationPage);
	}

	@Override
	public PaginationResult<InventoryInfo> queryInventories(int page, int maxResult, int maxNavigationPage) {
		return queryInventories(page, maxResult, maxNavigationPage, null);
	}

	@Override
	public void open(String id) {
        Inventory inventory = null;
 
        if (id != null) {
        	inventory = this.findInventory(id);
        }
        if (inventory == null) {
        	System.out.println("ets");
            return ;
        }
        inventory.setEtat(true);
        
        // If error in DB, Exceptions will be thrown out immediately
        this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void close(String id) {
		Inventory inventory = null;
		 
        if (id != null) {
        	inventory = this.findInventory(id);
        }
        if (inventory == null) {
            return ;
        }
        inventory.setEtat(false);
        
        // If error in DB, Exceptions will be thrown out immediately
        this.sessionFactory.getCurrentSession().flush();
		
	}
}
