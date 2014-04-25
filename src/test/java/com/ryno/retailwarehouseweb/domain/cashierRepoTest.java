/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.cashierRepository;
import com.ryno.retailwarehouseweb.repository.hardwareRepository;
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
public class cashierRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static cashierRepository repo;
    public cashierRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createCashier(){
        repo = ctx.getBean(cashierRepository.class);
       
        cashier cash = new cashier.Builder("jake", "2120", 2000.00)
                .Build();
        
        repo.save(cash);
        id = cash.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createCashier")
    public void readCashier(){
        repo = ctx.getBean(cashierRepository.class);
        cashier cash = repo.findOne(id);
        Assert.assertEquals(cash.getEmpNum(), "2120");
    }
    
    @Test(dependsOnMethods = "createCashier")
    private void updateCashier(){
        repo = ctx.getBean(cashierRepository.class);
        
        cashier cash = repo.findOne(id);
        cashier cashUpdate = new cashier.Builder(cash.getName(), cash.getEmpNum(), cash.returnSalary())
                .setName("bob")
                .Build();
        
        repo.save(cashUpdate);
    }
    
    @Test(dependsOnMethods = "readCashier")
    private void deleteCashier(){
        repo = ctx.getBean(cashierRepository.class);
        repo.delete(id);
        cashier cash = repo.findOne(id);
        Assert.assertNull(cash);
        
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
