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
public class cash implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private String color;

    public double getAmount(){
        return amount;
    }
    public String getColor(){
        return color;
    }
    
    public Long getId(){
        return id;
    }
    private cash(){};
    private cash(Builder build){
        this.amount=build.amount;
        this.color=build.color;
        this.id=build.id;
    }
    private cash(cash build){
        amount=build.amount;
        color=build.color;
        this.id=build.id;
    }
    public static class Builder{
        private double amount;
        private String color;
        private Long id;
        
        public Builder(double amt, String col){
            this.amount=amt;
            this.color=col;
        }
        
        public Builder setAmt(double amt){
            this.amount=amt;
            return this;
        }
        
        public Builder cash(cash build){
        this.amount=build.amount;
        this.color=build.color;
        this.id=build.id;
        return this;
    }
        
        public cash build(){
            return new cash(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final cash other = (cash) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cash{" + "id=" + id + '}';
    }
    
}
