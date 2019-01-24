package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.dao.InventoryAndProductDAO;
import com.example.demo.dao.InventoryDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entity.Product;
import com.example.demo.model.InventoryAndProductInfo;
import com.example.demo.model.InventoryInfo;
import com.example.demo.model.PaginationResult;
import com.example.demo.model.ProductInfo;
import com.example.demo.model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
@Controller
// Enable Hibernate Transaction.
@Transactional
// Need to use RedirectAttributes
@EnableWebMvc
public class MainController {
 
    @Autowired
    private ProductDAO productDAO;
    
    @Autowired
    private InventoryDAO inventoryDAO;
    
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private InventoryAndProductDAO inventoryAndProductDAO;
 
    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }
 
    @RequestMapping("/")
    public String home() {
        return "index";
    }
 
    // Product List page.
    @RequestMapping({ "/productList" })
    public String listProductHandler(Model model, //
            @RequestParam(value = "name", defaultValue = "") String likeName,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        final int maxResult = 5;
        final int maxNavigationPage = 10;
 
        PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
                maxResult, maxNavigationPage, likeName);
 
        model.addAttribute("paginationProducts", result);
        return "productList";
    }
 
    
 // User List page.
    @RequestMapping({ "/userList" })
    public String listUserHandler(Model model, //
            @RequestParam(value = "name", defaultValue = "") String likeName,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        final int maxResult = 5;
        final int maxNavigationPage = 10;
 
        PaginationResult<UserInfo> result = userDAO.queryUsers(page, //
                maxResult, maxNavigationPage, likeName);
 
        model.addAttribute("paginationUsers", result);
        return "userList";
    }
    
 // Inventory List page.
    @RequestMapping({ "/inventoryList" })
    public String listInventoryHandler(Model model, //
            @RequestParam(value = "name", defaultValue = "") String likeName,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        final int maxResult = 5;
        final int maxNavigationPage = 10;
 
        PaginationResult<InventoryInfo> result = inventoryDAO.queryInventories(page, //
                maxResult, maxNavigationPage, likeName);
 
        model.addAttribute("paginationInventories", result);
        return "inventoryList";
    }
    
    // Inventory List page.
    @RequestMapping({ "/inventory" })
    public String listInventoryAndProductsHandler(Model model, //
            @RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        final int maxResult = 5;
        final int maxNavigationPage = 10;
 
        PaginationResult<InventoryAndProductInfo> result = inventoryAndProductDAO.queryInventoryAndProducts(page, //
                maxResult, maxNavigationPage, id);
 
        model.addAttribute("paginationInventoryAndProducts", result);
        return "inventoryAndProductsList";
    }
    
    
    /*
    @RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
            @RequestParam("code") String code) throws IOException {
        Product product = null;
        if (code != null) {
            product = this.productDAO.findProduct(code);
        }
        if (product != null && product.getImage() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getImage());
        }
        response.getOutputStream().close();
    }*/
     
}