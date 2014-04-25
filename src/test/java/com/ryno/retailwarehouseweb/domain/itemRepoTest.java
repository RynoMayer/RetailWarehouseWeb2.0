/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.itemRepository;
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
public class itemRepoTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static itemRepository repo;
    public itemRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createItem(){
        repo = ctx.getBean(itemRepository.class);
       
        Item itemA = new Item.ItemBuilder("ItmOven75")
                .setType("appliance")
                .build();
        
        repo.save(itemA);
        id = itemA.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createItem")
    public void readItem(){
        repo = ctx.getBean(itemRepository.class);
        Item itemA = repo.findOne(id);
        Assert.assertEquals(itemA.getType(), "appliance");
    }
    
    @Test(dependsOnMethods = "createItem")
    private void updateItem(){
        repo = ctx.getBean(itemRepository.class);
        
        Item itemA = repo.findOne(id);
        Item itemUpdate = new Item.ItemBuilder(itemA.getBarcode())
                .setType("stationary")
                .build();
        
        repo.save(itemUpdate);
    }
    
    @Test(dependsOnMethods = "readItem")
    private void deleteItem(){
        repo = ctx.getBean(itemRepository.class);
        repo.delete(id);
        Item itemA = repo.findOne(id);
        Assert.assertNull(itemA);
        
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
