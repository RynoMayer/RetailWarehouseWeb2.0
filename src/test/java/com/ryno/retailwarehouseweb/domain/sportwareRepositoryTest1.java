/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.sportwareRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ryno
 */
public class sportwareRepositoryTest1 {
    
    private static Long id;
    public static ApplicationContext ctx;
    
    private static sportwareRepository repo;
    
    public sportwareRepositoryTest1() {
    }
@Test
    public static void createSportware(){
        repo = ctx.getBean(sportwareRepository.class);
        
        List <sportware> sportswareList = new ArrayList<sportware>();
        sportware ware = new sportware.Builder("ItmB004")
                .setDescrip("shoes")
                .Build();
        
        sportswareList.add(ware);
        
        
        sportware sport = new sportware.Builder("Ttmtek403")
                .setBrand("nike")
                .setDescrip("shirt")
                .setSportswareList(sportswareList)
                .Build();
        
        repo.save(sport);
        id = sport.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createSportware")
    public void readSportware(){
        repo = ctx.getBean(sportwareRepository.class);
        sportware ware = repo.findOne(id);
        Assert.assertEquals(ware.getBrand(), "nike");
    }
    
    @Test(dependsOnMethods = "createSportware")
    private void updateSportware(){
        repo = ctx.getBean(sportwareRepository.class);
        
        sportware ware = repo.findOne(id);
        sportware sportUpdate = new sportware.Builder(ware.getBarcode())
                .sportware(ware)
                .setBrand("Gucci")
                .Build();
        
        repo.save(sportUpdate);
    }
    
    @Test(dependsOnMethods = "updateSportware")
    private void deleteSportware(){
        repo = ctx.getBean(sportwareRepository.class);
        repo.delete(id);
        sportware ware = repo.findOne(id);
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
