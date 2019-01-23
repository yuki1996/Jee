package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "InventoryAndProduct", //
	uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class InventoryAndProduct implements Serializable {

    private static final long serialVersionUID = 7550745928843183535L;
    
    private String id;
    private Inventory inventory;
    private Product product;
    private int quantity;
 
    @Id
    @Column(name = "ID", length = 50, nullable = false)
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InventoryID", nullable = false, //
    foreignKey = @ForeignKey(name = "FK_CodeID") )
    public Inventory getInventory() {
        return inventory;
    }
 
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodeID", nullable = false, //
    foreignKey = @ForeignKey(name = "FK_InventoryID") )
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
 
    @Column(name = "Quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
}
