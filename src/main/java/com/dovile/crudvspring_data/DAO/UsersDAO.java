/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dovile.crudvspring_data.DAO;

import com.dovile.crudvspring_data.model.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Nikanoras
 */

public interface UsersDAO extends JpaRepository<Users, Integer> {
    @Query("Select u from Users u where u.username=:username")
    public List<Users> findByName(@Param("username") String username); 
    
}
