/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.repository;
import com.ryno.retailwarehouseweb.domain.total;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author ryno
 */
public interface totalRepo extends JpaRepository<total, Long>{
    
}
