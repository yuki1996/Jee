package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name = "Users")
public class User implements Serializable {

	private static final long serialVersionUID = -2054386655979281969L;
	 
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
 
    private String id;
    private String email;
    private String password;
    private boolean active;
    private String userRole;
 
    @Id
    @Column(name = "id", length = 50, nullable = false)
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
    @Column(name = "email", length = 256, nullable = false)
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    @Column(name = "Password", length = 256, nullable = false)
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
    	this.password = DigestUtils.sha256Hex(password);
    }
 
    @Column(name = "Active", length = 1, nullable = false)
    public boolean isActive() {
        return active;
    }
 
    public void setActive(boolean active) {
        this.active = active;
    }
 
    @Column(name = "User_Role", length = 20, nullable = false)
    public String getUserRole() {
        return userRole;
    }
 
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    @Override
    public String toString()  {
        return "["+ this.email+","+ this.password+","+ this.userRole+"]";
    }
}
