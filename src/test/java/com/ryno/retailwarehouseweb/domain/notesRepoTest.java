/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ryno.retailwarehouseweb.domain;

import com.ryno.retailwarehouseweb.app.config.ConnectionConfig;
import com.ryno.retailwarehouseweb.repository.managerRepository;
import com.ryno.retailwarehouseweb.repository.notesRepository;
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
public class notesRepoTest {
    private static ApplicationContext ctx;
    private static Long id;
    private static notesRepository repo;
    public notesRepoTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
        public static void createManager(){
        repo = ctx.getBean(notesRepository.class);
       
        notes note = new notes.Builder("$", 200)
                .build();
        
        repo.save(note);
        id = note.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createManager")
    public void readManager(){
        repo = ctx.getBean(notesRepository.class);
        notes note = repo.findOne(id);
        Assert.assertEquals(note.getAbbv(), "$");
    }
    
    @Test(dependsOnMethods = "createManager")
    private void updateManager(){
        repo = ctx.getBean(notesRepository.class);
        
        notes note = repo.findOne(id);
        notes noteUpdate = new notes.Builder(note.getAbbv(),note.getValue())
                .setAbbr("%")
                .build();
        
        repo.save(noteUpdate);
    }
    
    @Test(dependsOnMethods = "readManager")
    private void deleteManager(){
        repo = ctx.getBean(notesRepository.class);
        repo.delete(id);
        notes note = repo.findOne(id);
        Assert.assertNull(note);
        
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
