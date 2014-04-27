/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.changeRepo;
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
public class changeRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static changeRepo repo;
    public changeRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
        public static void creatChange(){
        repo = ctx.getBean(changeRepo.class);
       
        change change2 = new change.Builder(23.05)
                .build();
        
        repo.save(change2);
        id = change2.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createChange")
    public void readChange(){
        repo = ctx.getBean(changeRepo.class);
        change change2 = repo.findOne(id);
        Assert.assertEquals(change2.getAmount(), 23.05);
    }
    
    @Test(dependsOnMethods = "createChange")
    private void updateChange(){
        repo = ctx.getBean(changeRepo.class);
        
        change change2 = repo.findOne(id);
        change cashUpdate = new change.Builder(change2.getAmount())
                .setAmt(55.80)
                .build();
        
        repo.save(cashUpdate);
    }
    
    @Test(dependsOnMethods = "readChange")
    private void deleteChange(){
        repo = ctx.getBean(changeRepo.class);
        repo.delete(id);
        change change2 = repo.findOne(id);
        Assert.assertNull(change2);
        
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
