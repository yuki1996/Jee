package com.example.demo.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public class ProductInfo {
	
    private String code;
    private String name;
    private boolean newProduct=false;
    private CommonsMultipartFile fileData;// Upload file.
 
    public ProductInfo() {}
    
    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
    }

    public ProductInfo(String code, String name) {
        this.code = code;
        this.name = name;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
 
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}