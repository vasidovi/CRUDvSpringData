/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dovile.crudvspring_data.controllers;

import com.dovile.crudvspring_data.DAO.AddressDAO;
import com.dovile.crudvspring_data.DAO.PersonDAO;
import com.dovile.crudvspring_data.model.Address;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class AddressController {
    
    @Autowired
    AddressDAO addressDAO;
    
    @Autowired
    PersonDAO personDAO;

    
    @GetMapping(value ="persons/{id}/addresses")
    public ModelAndView getAddressList(@PathVariable Integer id) {
        List<Address> list = addressDAO.findByPersonId(personDAO.getOne(id));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addresses");
        mv.addObject("addressesList", list);
        mv.addObject("personId", id);
        return mv;
    }
    
     @GetMapping(value ="persons/{p_id}/addresses/{id}/delete")
    public String deleteAddress(@PathVariable String p_id, @PathVariable Integer id) {
        
      addressDAO.deleteById(id);
       return "redirect: ../";
    }
    
 
    @GetMapping(value = {"persons/{p_id}/addresses/{id}/forms"})
    public ModelAndView selectAddress( @PathVariable String p_id, @PathVariable Integer id) {
       Address a = addressDAO.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addressform");
        mv.addObject("address", a);
        return mv;
    }
    
    @GetMapping("persons/{p_id}/addresses/forms")
    public ModelAndView newAddress(@PathVariable Integer p_id) {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addressform");        
        Address a = new Address();
        a.setPersonId(personDAO.getOne(p_id));      
        mv.addObject("address", a);
        return mv;
    }
    
    @PostMapping(value ={"persons/{p_id}/addresses/{id}/save", "persons/{p_id}/addresses/save"})
    public String saveUpdateAddress(
            @PathVariable Integer p_id,
            @ModelAttribute("address") Address a,
      BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Error" + result.getAllErrors().toString());
           return "redirect:../";
            
        }
        addressDAO.save(a);    
            return "redirect:/persons/"+p_id+"/addresses";
        }    
    
    
}
