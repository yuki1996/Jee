package com.example.demo.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import com.example.demo.entity.User;

public class InventoryInfo {


    private boolean newInventory=false;
    private String id;
    private Date createDate;
    private boolean etat;
    private User user;

    public InventoryInfo() {
    	
    }
    
    public InventoryInfo(String id, Date createDate, boolean etat,  String userId, 
    		String  userEmail, String userPassword, String userRole) {
    	this.id = id;
    	this.createDate = createDate;
    	this.etat = etat;
    	this.user = new User();
    	this.user.setId(userId);
    	this.user.setEmail(userEmail);
    	this.user.setPassword(userPassword);
    	this.user.setUserRole(userRole);
    }
    
    public InventoryInfo(String id, Date createDate, boolean etat,  User user) {
    	this.id = id;
    	this.createDate = createDate;
    	this.etat = etat;
    	this.user = user;
    }
    
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public boolean getEtat() {
        return etat;
    }
 
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public boolean getInventory() {
		return newInventory;
	}
    
	public void setNewInventory(boolean b) {
		newInventory = b;
	}

}
