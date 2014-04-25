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
public class supplier implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Company;
    private String type;

    public String getCompany(){
        return Company;
    }
    public String getType(){
        return type;
    }
    
    public Long getId(){
        return id;
    }
    
    private supplier(){};
    
    private supplier(Builder build){
        this.Company=build.Company;
        this.type=build.type;
        this.id=build.id;
    }
    
    private supplier(supplier build){
        this.Company=build.Company;
        this.type=build.type;
        this.id=build.id;
    }
    
    public static class Builder{
        private String Company;
        private String type;
        private Long id;
        
        public Builder(String bcode){
            this.type=bcode;
          
        }
        
        
        public Builder setCompany(String comp){
            this.Company=comp;
            return this;
        }
        
        public Builder supplier(supplier build){
        this.Company=build.Company;
        this.type=build.type;
        this.id=build.id;
        return this;
    }
        public supplier build(){
            return new supplier(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final supplier other = (supplier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "supplier{" + "id=" + id + '}';
    }
    
}
