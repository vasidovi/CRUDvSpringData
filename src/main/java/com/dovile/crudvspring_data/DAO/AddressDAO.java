/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dovile.crudvspring_data.DAO;

import com.dovile.crudvspring_data.model.Address;
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
public interface AddressDAO extends JpaRepository<Address, Integer> {
//  
    @Query("Select a from Address a where a.personId=:personId")
    public List<Address> findByPersonId(@Param("personId") Person personId); 
    
       
  }
    

