package com.example.demo.model;

public class UserInfo {

    private String email;
    private String password;
    private boolean valid;
    private String user_Role;
    private String id;
    
    public UserInfo() {
    	
    }
  
    public UserInfo(String id,String email, String password, String userRole) {
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.user_Role = userRole;
    }
    
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isValid() {
        return valid;
    }
 
    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    public String getUserRole() {
        return user_Role;
    }
 
    public void setUserRole(String userRole) {
        this.user_Role = userRole;
    }

    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
}
