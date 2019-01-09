/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dovile.crudvspring_data.controllers;

import com.dovile.crudvspring_data.DAO.PersonDAO;
import com.dovile.crudvspring_data.model.Person;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dovile
 */
@Controller
public class PersonControler {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping(value = {"", "/", "persons"})
    public ModelAndView getPersonList() {
        List<Person> list = personDAO.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping(value = {"/ws"}, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<Person> getPersonListJSON() {
        List<Person> list = personDAO.findAll();
        return list;
    }

    @PostMapping(value = {"/ws"}, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Person postPersonJSON(@RequestBody Person p) {
        personDAO.save(p);
        return p;
    }

    @GetMapping(value = {"/seed"})
    public String seed() {

        System.out.println(encoder.encode("password1"));
        return "redirect:/";

    }

    // not needed
//    @GetMapping(value = {"/logout"})
//    public String logout(HttpServletRequest request){
//         HttpSession session = request.getSession();
//        session.invalidate();
//        return "redirect:/";
//        
//    }
    @GetMapping(value = "persons/{id}/delete")
    public String deletePerson(@PathVariable Integer id) {
        personDAO.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "persons/{id}/forms")
    public ModelAndView selectPerson(@PathVariable Integer id) {

        Person p = personDAO.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("personform");
        mv.addObject("person", p);
        return mv;
    }

    @GetMapping("persons/forms")
    public ModelAndView newPerson() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("personform");
        mv.addObject("person", new Person());
        return mv;
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        binder.registerCustomEditor(Date.class, "birthDate", new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "persons/save", method = RequestMethod.POST)
    public String saveUpdatePerson(@ModelAttribute("person") Person p,
            BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Error" + result.getAllErrors().toString());
            return "redirect:/";

        }
        System.out.println("My binded date is " + p.getBirthDate());
        personDAO.save(p);
        return "redirect:/";
    }

    private static final Log log = LogFactory.getLog(PersonControler.class);

}
