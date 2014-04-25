/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.itemsRepository;
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
public class itemsRepositoryTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static itemsRepository repo;
    public itemsRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createItems(){
        repo = ctx.getBean(itemsRepository.class);
       
        items itemsB = new items.Builder("ItmShoe75")
                .descrip("Trainer")
                .build();
        
        repo.save(itemsB);
        id = itemsB.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createItems")
    public void readItems(){
        repo = ctx.getBean(itemsRepository.class);
        items itemsB = repo.findOne(id);
        Assert.assertEquals(itemsB.getDescrip(), "Trainer");
    }
    
    @Test(dependsOnMethods = "createItems")
    private void updateItems(){
        repo = ctx.getBean(itemsRepository.class);
        
        items itemsB = repo.findOne(id);
        items itemsUpdate = new items.Builder(itemsB.getBarcode())
                .descrip("Tekkie")
                .build();
        
        repo.save(itemsUpdate);
    }
    
    @Test(dependsOnMethods = "readItems")
    private void deleteItems(){
        repo = ctx.getBean(itemsRepository.class);
        repo.delete(id);
        items itemsB = repo.findOne(id);
        Assert.assertNull(itemsB);
        
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
