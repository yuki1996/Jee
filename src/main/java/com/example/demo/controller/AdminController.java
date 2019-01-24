package com.example.demo.controller;

import java.util.UUID;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;
import com.example.demo.model.ProductInfo;
import com.example.demo.model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
public class AdminController {
 
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;
    
    // GET: Show Login Page
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model) {
 
        return "login";
    }

 
    // GET: Show product.
    @RequestMapping(value = { "/product" }, method = RequestMethod.GET)
    public String product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
        ProductInfo productInfo = null;
 
        if (code != null && code.length() > 0) {
            productInfo = productDAO.findProductInfo(code);
        }
        
        if (productInfo == null) {
            productInfo = new ProductInfo();
            productInfo.setNewProduct(true);
        }
        
        model.addAttribute("productForm", productInfo);
        return "product";
    }
 
    // POST: Save product
    @RequestMapping(value = { "/product" }, method = RequestMethod.POST)
    // Avoid UnexpectedRollbackException (See more explanations)
    @Transactional(propagation = Propagation.NEVER)
    public String productSave(Model model, //
            @ModelAttribute("productForm") ProductInfo productInfo, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "product";
        }
        try {
            productDAO.save(productInfo);
        } catch (Exception e) {
            // Need: Propagation.NEVER?
            String message = e.getMessage();
            model.addAttribute("message", message);
            // Show product form.
            return "product";
 
        }
        return "redirect:/productList";
    }
    
 // GET: delete product
    @RequestMapping(value = { "/removeProduct" }, method = RequestMethod.GET)
    // Avoid UnexpectedRollbackException (See more explanations)
    @Transactional(propagation = Propagation.NEVER)
    public String productRemove(Model model, //
            @ModelAttribute("productForm") ProductInfo productInfo, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "403";
        }
        try {
            productDAO.delete(productInfo);
        } catch (Exception e) {
            // Need: Propagation.NEVER?
            String message = e.getMessage();
            model.addAttribute("message", message);
            // Show product form.
            return "redirect:/productList";
 
        }
        return "redirect:/productList";
    }
    
    
 // GET: Show user.
    @RequestMapping(value = { "/user" }, method = RequestMethod.GET)
    public String user(Model model, @RequestParam(value = "id", defaultValue = "") String id) {
    	UserInfo userInfo = null;
 
        if (id != null && id.length() > 0) {
        	userInfo = userDAO.findUserInfo(id);
        }
        
        if (userInfo == null) {
        	userInfo = new UserInfo();
        	userInfo.setNewUser(true);
        	userInfo.setId(UUID.randomUUID().toString());
        	userInfo.setUserRole(User.ROLE_USER);
        }
        userInfo.setPassword("");
        model.addAttribute("userForm", userInfo);
        return "user";
    }
 
    // POST: Save user
    @RequestMapping(value = { "/user" }, method = RequestMethod.POST)
    // Avoid UnexpectedRollbackException (See more explanations)
    @Transactional(propagation = Propagation.NEVER)
    public String userSave(Model model, //
            @ModelAttribute("userForm") UserInfo userInfo, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "user";
        }
        try {
        	userDAO.save(userInfo);
        } catch (Exception e) {
            // Need: Propagation.NEVER?
            String message = e.getMessage();
            model.addAttribute("message", message);
            // Show user form.
            return "user";
 
        }
        return "redirect:/userList";
    }
    
 // GET: delete user
    @RequestMapping(value = { "/removeUser" }, method = RequestMethod.GET)
    // Avoid UnexpectedRollbackException (See more explanations)
    @Transactional(propagation = Propagation.NEVER)
    public String userRemove(Model model, //
            @ModelAttribute("userForm") UserInfo userInfo, //
            BindingResult result, //
            final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "403";
        }
        try {
        	userDAO.delete(userInfo);
        } catch (Exception e) {
            // Need: Propagation.NEVER?
            String message = e.getMessage();
            model.addAttribute("message", message);
            // Show user form.
            return "redirect:/userList";
 
        }
        return "redirect:/userList";
    }
 
    
}