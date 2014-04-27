/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.cashRepo;
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
public class cashRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static cashRepo repo;
    public cashRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

     @Test
        public static void createCash(){
        repo = ctx.getBean(cashRepo.class);
       
        cash cash1 = new cash.Builder(500.0, "blue")
                .build();
        
        repo.save(cash1);
        id = cash1.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createCash")
    public void readCash(){
        repo = ctx.getBean(cashRepo.class);
        cash cash1 = repo.findOne(id);
        Assert.assertEquals(cash1.getAmount(), 500.0);
    }
    
    @Test(dependsOnMethods = "createCash")
    private void updateCash(){
        repo = ctx.getBean(cashRepo.class);
        
        cash cash1 = repo.findOne(id);
        cash cashUpdate = new cash.Builder(cash1.getAmount(),cash1.getColor())
                .setAmt(100.0)
                .build();
        
        repo.save(cashUpdate);
    }
    
    @Test(dependsOnMethods = "readCash")
    private void deleteCash(){
        repo = ctx.getBean(cashRepo.class);
        repo.delete(id);
        cash cash1 = repo.findOne(id);
        Assert.assertNull(cash1);
        
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
