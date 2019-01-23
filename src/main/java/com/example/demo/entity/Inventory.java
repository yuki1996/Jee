package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Inventories", //
	uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class Inventory implements Serializable {
	 
    private static final long serialVersionUID = -2576670215015463100L;


    private String id;
    private User user;
    private Date createDate;
    private boolean etat;
 
    @Id
    @Column(name = "ID", length = 50, nullable = false)
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodeID", nullable = false, //
    foreignKey = @ForeignKey(name = "FK_creatorID") )
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    @Column(name = "createDate", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    @Column(name = "etat", length = 1, nullable = false)
    public boolean isActive() {
        return etat;
    }
 
    public void setActive(boolean etat) {
        this.etat = etat;
    }
}
