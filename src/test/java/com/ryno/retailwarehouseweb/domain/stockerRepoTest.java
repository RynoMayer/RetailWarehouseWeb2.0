/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.hardwareRepository;
import com.ryno.retailwarehouseweb.repository.stockerRepository;
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
public class stockerRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static stockerRepository repo;
    public stockerRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createStocker(){
        repo = ctx.getBean(stockerRepository.class);
       
        Stocker stocker = new Stocker.Builder("dan", "789", 1500.00)
                .Build();
        
        repo.save(stocker);
        id = stocker.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createStocker")
    public void readStocker(){
        repo = ctx.getBean(stockerRepository.class);
        Stocker stocker = repo.findOne(id);
        Assert.assertEquals(stocker.getEmpNum(), "789");
    }
    
    @Test(dependsOnMethods = "createStocker")
    private void updateStocker(){
        repo = ctx.getBean(stockerRepository.class);
        
        Stocker stocker = repo.findOne(id);
        Stocker stockerUpdate = new Stocker.Builder(stocker.getName(), stocker.getEmpNum(), stocker.returnSalary())
                .setSalary(2001.00)
                .Build();
        
        repo.save(stockerUpdate);
    }
    
    @Test(dependsOnMethods = "readStocker")
    private void deleteStocker(){
        repo = ctx.getBean(stockerRepository.class);
        repo.delete(id);
        Stocker stocker = repo.findOne(id);
        Assert.assertNull(stocker);
        
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
