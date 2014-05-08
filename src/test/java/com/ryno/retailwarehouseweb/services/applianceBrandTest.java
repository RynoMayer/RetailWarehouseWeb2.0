/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.services;

import com.ryno.retailwarehouseweb.ConnectionConfigTest;
import com.ryno.retailwarehouseweb.domain.Appliance;
import com.ryno.retailwarehouseweb.repository.applianceRepository;
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
 * @author Ryno
 */
public class applianceBrandTest {
    private static ApplicationContext ctx;
    private ApplianceBrandService appBrandService;
    private applianceRepository appRepo;
    
    
    
    public applianceBrandTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void getBrandStart(){
        appBrandService = ctx.getBean(ApplianceBrandService.class);
        appRepo=ctx.getBean(applianceRepository.class);
        
        Appliance app1 = new Appliance.Builder("app1nm").brand("Samsung").Build();
        
        Appliance app2 = new Appliance.Builder("app2566g").brand("steel").Build();
        
        Appliance app3 = new Appliance.Builder("app2jkg").brand("kevin").Build();
         
        appRepo.save(app1);
        appRepo.save(app2);
        appRepo.save(app3);
        
        List <Appliance> apps ;
                apps= appBrandService.getBrandStart("s");
        
        Assert.assertEquals(apps.size(),2);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
