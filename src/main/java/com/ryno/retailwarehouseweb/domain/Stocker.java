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
import java.io.Serializable;

/**
 *
 * @author ryno
 */
@Entity
public class Stocker implements Serializable{
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
        
        return salary;
    }
    public String getEmpNum(){
        return employeeNum;
    }
    
      private Stocker(Builder build){
        name=build.name;
        salary=build.salary;
        employeeNum=build.employeeNum;
    }
    
    public static class Builder{
        private String name;
        private double salary;
        private String employeeNum;
        
        public Builder(String name, String empN, double sal){
            this.name=name;
            this.employeeNum=empN;
            this.salary=sal;
        }
        
        public Builder setSalary(double sal){
            this.salary=sal;
            return this;
        }
        public Stocker Build(){
            return new Stocker(this);
        }
    }
}
