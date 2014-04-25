/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.stationaryRepository;
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
public class stationaryRepoTest {
     private static ApplicationContext ctx;
    private static Long id;
    private static stationaryRepository repo;
    public stationaryRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createStationary(){
        repo = ctx.getBean(stationaryRepository.class);
       
        stationary stat = new stationary.Builder("ItmScissor75")
                .descrip("Scissor")
                .brand("waltons")
                .Build();
        
        repo.save(stat);
        id = stat.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createStationary")
    public void readStationary(){
        repo = ctx.getBean(stationaryRepository.class);
        stationary stat = repo.findOne(id);
        Assert.assertEquals(stat.getBrand(), "waltons");
    }
    
    @Test(dependsOnMethods = "createStationary")
    private void updateStationary(){
        repo = ctx.getBean(stationaryRepository.class);
        
        stationary stat = repo.findOne(id);
        stationary statUpdate = new stationary.Builder(stat.getBarcode())
                .brand("snip")
                .descrip("snip-snip")
                .Build();
        
        repo.save(statUpdate);
    }
    
    @Test(dependsOnMethods = "readStationary")
    private void deleteStationary(){
        repo = ctx.getBean(stationaryRepository.class);
        repo.delete(id);
        stationary stat = repo.findOne(id);
        Assert.assertNull(stat);
        
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
