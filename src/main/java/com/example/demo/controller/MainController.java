package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.PersonForm;
import com.example.demo.model.Person;
 
@Controller
public class MainController {
 
    private static List<Person> persons = new ArrayList<Person>();
 
    public static final String EMAIL_VALID = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$";
    public static final String PASSWORD_VALID = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    
    static {
        persons.add(new Person("Bill@truc.com", "Gates"));
        persons.add(new Person("Steve@truc.com", "mdp"));
    }
 
    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("message", message);
 
        return "index";
    }
 
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
 
        return "addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
            @ModelAttribute("personForm") PersonForm personForm) {
 
        String mail = personForm.getMail();
        String password = personForm.getPassword();
        
        if (mail == null || mail.length() == 0 || password == null 
        		|| password.length() == 0) {
        	model.addAttribute("errorMessage", "l'email et le mot de passe sont obligatoires ");
            return "addPerson";
        }
        
        System.out.println("validate mail"+Pattern.matches(EMAIL_VALID, mail));
        System.out.println("validate password"+Pattern.matches(PASSWORD_VALID, password));
        boolean validateMail = Pattern.matches(EMAIL_VALID, mail);
        
        if (!validateMail) {
        	model.addAttribute("errorMessage", "le mail est invalide");
            return "addPerson";
        } 
        
        
        if (!Pattern.matches(PASSWORD_VALID, password)) {
        	model.addAttribute("errorMessage", "le mot de passe ne correspond pas au norme de sécurité");
            return "addPerson";
        } 
        
        Person newPerson = new Person(mail, password);
        persons.add(newPerson);

        return "redirect:/personList";
    }
 
}
