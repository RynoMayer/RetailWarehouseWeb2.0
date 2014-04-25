/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryno.retailwarehouseweb.domain;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author ryno
 */
@Entity
public class cashier implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double salary;
    private String employeeNum;
    
    public String getName(){
        return name;
    }
    public double returnSalary(){
        salary+=500;
        return salary;
    }
    public String getEmpNum(){
        return employeeNum;
    }
    
     public Long getId(){return id;}
     
     private cashier(){};
     
     private cashier(Builder build){
        this.name=build.name;
        this.salary=build.salary;
        this.employeeNum=build.employeeNum;
        this.id=build.id;
    }
    
    public static class Builder{
        private String name;
        private double salary;
        private String employeeNum;
        private Long id;
        public Builder(String name, String empN, double sal){
            this.name=name;
            this.employeeNum=empN;
            this.salary=sal;
        }
        
        public Builder setName(String n){
            this.name=n;
            return this;
        }
        
        public Builder cashier(Builder build){
        this.name=build.name;
        this.salary=build.salary;
        this.employeeNum=build.employeeNum;
        this.id=build.id;
        return this;
    }
        
        public cashier Build(){
            return new cashier(this);
        }
    }
}
