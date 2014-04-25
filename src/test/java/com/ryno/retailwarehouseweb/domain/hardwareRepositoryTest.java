/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;


import com.ryno.retailwarehouseweb.repository.hardwareRepository;
import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
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
 * @author Ryno
 */
public class hardwareRepositoryTest {
    
    private static ApplicationContext ctx;
    private static Long id;
    private static hardwareRepository repo;
    
    public hardwareRepositoryTest() {
    }
    
        @Test
        public static void createHardware(){
        repo = ctx.getBean(hardwareRepository.class);
       
        hardware hware = new hardware.Builder("Itmhammer75")
                .descrip("claw hammer")
                .brand("stahl")
                .Build();
        
        repo.save(hware);
        id = hware.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createHardware")
    public void readHardware(){
        repo = ctx.getBean(hardwareRepository.class);
        hardware hware = repo.findOne(id);
        Assert.assertEquals(hware.getBrand(), "stahl");
    }
    
    @Test(dependsOnMethods = "createHardware")
    private void updateHardware(){
        repo = ctx.getBean(hardwareRepository.class);
        
        hardware hware = repo.findOne(id);
        hardware hardUpdate = new hardware.Builder(hware.getBarcode())
                .brand("PPC")
                .Build();
        
        repo.save(hardUpdate);
    }
    
    @Test(dependsOnMethods = "readHardware")
    private void deleteHardware(){
        repo = ctx.getBean(hardwareRepository.class);
        repo.delete(id);
        hardware ware = repo.findOne(id);
        Assert.assertNull(ware);
        
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
