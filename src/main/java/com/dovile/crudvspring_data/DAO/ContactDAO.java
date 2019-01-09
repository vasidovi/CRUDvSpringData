/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dovile.crudvspring_data.DAO;

import com.dovile.crudvspring_data.model.Contact;
import com.dovile.crudvspring_data.model.Person;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Nikanoras
 */
@Transactional
public interface ContactDAO extends JpaRepository<Contact, Integer> {
//  
    @Query("Select c from Contact c where c.personId=:personId")
    public List<Contact> findByPersonId(@Param("personId") Person personId); 
       
  }
    

