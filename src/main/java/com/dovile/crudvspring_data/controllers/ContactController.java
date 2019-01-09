/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dovile.crudvspring_data.controllers;

import com.dovile.crudvspring_data.DAO.ContactDAO;
import com.dovile.crudvspring_data.DAO.PersonDAO;
import com.dovile.crudvspring_data.model.Contact;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dovile
 */

@Controller
public class ContactController {
    
    @Autowired
    ContactDAO contactDAO;
    
    @Autowired
    PersonDAO personDAO;
    
    
     @GetMapping(value ="persons/{id}/contacts")
    public ModelAndView getContactsList(@PathVariable Integer id) throws SQLException {
        List<Contact> list =  contactDAO.findByPersonId(personDAO.getOne(id));                                  
        ModelAndView mv = new ModelAndView();
        mv.setViewName("contacts");
        mv.addObject("contactsList", list);
        mv.addObject("personId", id);
        return mv;
    }
    
    @GetMapping(value ="persons/{p_id}/contacts/{id}/delete")
    public String deleteContact(@PathVariable String p_id, 
       @PathVariable Integer id) throws SQLException {
       
        contactDAO.delete(contactDAO.getOne(id));
       return "redirect: ../";
    }
    
 
    @GetMapping(value = {"persons/{p_id}/contacts/{id}/forms"})
    public ModelAndView selectContact(@PathVariable String p_id, @PathVariable Integer id) {
        Contact c = contactDAO.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("contactform");
        mv.addObject("contact", c);
        return mv;
    }
    
    @GetMapping("persons/{p_id}/contacts/forms")
    public ModelAndView newContact(@PathVariable Integer p_id) {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("contactform");
        
        Contact c = new Contact();
        c.setPersonId(personDAO.getOne(p_id));
      
        mv.addObject("contact", c);
        return mv;
    }
    
    @PostMapping(value ={"persons/{p_id}/contacts/{id}/save", "persons/{p_id}/contacts/save"})
    public String saveUpdateContact(
            @PathVariable Integer p_id,
            @ModelAttribute("contact") Contact c,
      BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Error" + result.getAllErrors().toString());
           return "redirect:../";
            
        }
        contactDAO.save(c);
        
            return "redirect:/persons/"+p_id+"/contacts";
        }
    
    
    
}
