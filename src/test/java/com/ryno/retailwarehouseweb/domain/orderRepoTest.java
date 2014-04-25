/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.orderRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ryno
 */
public class orderRepoTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static orderRepository repo;
    public orderRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createOrder(){
        repo = ctx.getBean(orderRepository.class);
       
        orders orderA = new orders.Builder("ItmLenovo54","Laptop","Lenovo","Electronics")
                //.setDescrip("Laptop")
                //.setCompany("Lenovo")
                //.setType("Electronics")
                .build();
        
        repo.save(orderA);
        id = orderA.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createOrder")
    public void readOrder(){
        repo = ctx.getBean(orderRepository.class);
        orders orderA = repo.findOne(id);
        Assert.assertEquals(orderA.getBarcode(), "ItmLenovo54");
    }
    
    @Test(dependsOnMethods = "createOrder")
    private void updateOrder(){
        repo = ctx.getBean(orderRepository.class);
        
        orders orderA = repo.findOne(id);
        orders OrderUpdate = new orders.Builder(orderA.getBarcode(),orderA.getDescrip(), orderA.getCompany(), orderA.getType())
                .setCompany("PPC")
                .setDescrip("tablet")
                .setType("Electronics")
                .build();
        
        repo.save(OrderUpdate);
    }
    
    @Test(dependsOnMethods = "readOrder")
    private void deleteOrder(){
        repo = ctx.getBean(orderRepository.class);
        repo.delete(id);
        orders orderA = repo.findOne(id);
        Assert.assertNull(orderA);
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
