/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.totalRepo;
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
public class totalRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static totalRepo repo;
    public totalRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

     @Test
        public static void createTotal(){
        repo = ctx.getBean(totalRepo.class);
       
        total total2 = new total.Builder(660.50)
                .build();
        
        repo.save(total2);
        id = total2.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createTotal")
    public void readTotal(){
        repo = ctx.getBean(totalRepo.class);
        total total2 = repo.findOne(id);
        Assert.assertEquals(total2.getAmount(), 660.50);
    }
    
    @Test(dependsOnMethods = "createTotal")
    private void updateTotal(){
        repo = ctx.getBean(totalRepo.class);
        
        total total2 = repo.findOne(id);
        total totalUpdate = new total.Builder(total2.getAmount())
                .setAmt(155.80)
                .build();
        
        repo.save(totalUpdate);
    }
    
    @Test(dependsOnMethods = "readTotal")
    private void deleteTotal(){
        repo = ctx.getBean(totalRepo.class);
        repo.delete(id);
        total total2 = repo.findOne(id);
        Assert.assertNull(total2);
        
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
