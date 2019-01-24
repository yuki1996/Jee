package com.example.demo.model;

public class UserInfo {

    private String email;
    private String password;
    private String userRole;
    private boolean newUser=false;
    private String id;
    
    public UserInfo() {
    	
    }
  
    public UserInfo(String id,String email, String password, String userRole) {
    	this.id = id;
    	this.email = email;
    	this.password = password;
    	this.userRole = userRole;
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
    
    public String getUserRole() {
        return userRole;
    }
 
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }

    public boolean getNewUser() {
		return newUser;
	}
    
	public void setNewUser(boolean b) {
		newUser = b;
	}
}
