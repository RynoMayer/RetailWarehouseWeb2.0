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
public class notes implements Serializable{
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private int v_values;
    private String abbv;
    
    public int getValue(){
        return v_values;
    }
    public String getAbbv(){
        return abbv;
    }
    
    public Long getId(){
        return id;
    }
    
    private notes(){};
    
    private notes(Builder build){
        this.abbv=build.abbv;
        this.v_values=build.v_values;
        this.id=build.id;
    }
    
    private notes(notes item){
        this.abbv=item.abbv;
        this.v_values=item.v_values;
        this.id=item.id;
    
    }
    
    public static class Builder{
        private int v_values;
        private String abbv;
        private Long id; 
        
        public Builder(String abbrev, int val){
            this.v_values=val;
            this.abbv=abbrev;
        }
        
        public Builder setAbbr(String abb){
            this.abbv=abb;
            return this;
        }
        
        public Builder notes(notes item){
        this.abbv=item.abbv;
        this.v_values=item.v_values;
        this.id=item.id;
        return this;
    }
        
        public notes build(){
            return new notes(this);
        }
       /* public Builder addNotes(notes b){
            noteList.add( b);
            return this;
        }*/
    }
}
