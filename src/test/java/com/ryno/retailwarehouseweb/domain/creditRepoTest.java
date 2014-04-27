/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.creditRepo;
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
public class creditRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static creditRepo repo;
    public creditRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createCredit(){
        repo = ctx.getBean(creditRepo.class);
       
        credit card = new credit.Builder(550.0, 987456)
                .setBank("FNB")
                .build();
        
        repo.save(card);
        id = card.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createCredit")
    public void readCredit(){
        repo = ctx.getBean(creditRepo.class);
        credit card = repo.findOne(id);
        Assert.assertEquals(card.getAmount(), 550.0);
    }
    
    @Test(dependsOnMethods = "createCredit")
    private void updateCredit(){
        repo = ctx.getBean(creditRepo.class);
        
        credit card = repo.findOne(id);
        credit cardUpdate = new credit.Builder(card.getAmount(),card.getCardNum())
                .setBank("absa")
                .build();
        
        repo.save(cardUpdate);
    }
    
    @Test(dependsOnMethods = "readCredit")
    private void deleteCredit(){
        repo = ctx.getBean(creditRepo.class);
        repo.delete(id);
        credit card = repo.findOne(id);
        Assert.assertNull(card);
        
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
