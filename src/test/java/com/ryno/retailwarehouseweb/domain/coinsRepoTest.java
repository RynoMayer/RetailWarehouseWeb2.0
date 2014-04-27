/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.coinsRepository;
import com.ryno.retailwarehouseweb.repository.managerRepository;
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
public class coinsRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static coinsRepository repo;
    public coinsRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createCoins(){
        repo = ctx.getBean(coinsRepository.class);
       
        Coins coin = new Coins.Builder("R",10)
                .build();
        
        repo.save(coin);
        id = coin.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createCoins")
    public void readCoins(){
        repo = ctx.getBean(coinsRepository.class);
        Coins coin = repo.findOne(id);
        Assert.assertEquals(coin.getAbbv(), "R");
    }
    
    @Test(dependsOnMethods = "createCoins")
    private void updateCoins(){
        repo = ctx.getBean(coinsRepository.class);
        
        Coins coin = repo.findOne(id);
        Coins coinUpdate = new Coins.Builder(coin.getAbbv(),coin.getValue())
                .setAbbr("$")
                .build();
        
        repo.save(coinUpdate);
    }
    
    @Test(dependsOnMethods = "readCoins")
    private void deleteCoins(){
        repo = ctx.getBean(coinsRepository.class);
        repo.delete(id);
        Coins coin = repo.findOne(id);
        Assert.assertNull(coin);
        
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
