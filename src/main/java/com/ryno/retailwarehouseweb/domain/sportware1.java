/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryno.retailwarehouseweb.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
/**
 *
 * @author ryno
 */
@Entity
@SuppressWarnings("ConsistentAccessType")
public class sportware1 implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String barcode;
    private String descrip;
    private String brand;
    @OneToMany (cascade = CascadeType.ALL)
    //@JoinColumn (name="")
        List<sportware1> sportswareList;
    
    
    public String Types(){
        return "sportware";
    }
     
    public String getBarcode(){
        return barcode;
    }
    public String getDescrip(){
        return descrip;
    }
    public String getBrand(){
        return brand;
    }
    
    
    
   
    
    private sportware1(Builder build){
        barcode=build.barcode;
    }
    
    private sportware1(sportware1 item){
        this.barcode = item.barcode;
        this.brand = item.brand;
        this.descrip = item.descrip;
    }
     
    
        public List<sportware1> getSportswareList()
        {
            return sportswareList;
        }
    
    public static class Builder{
        private String barcode;
        private String descrip;
        private String brand;    
      private long id;
         List<sportware1> sportswareList;
        
        public Builder(String bcode){
            this.barcode=bcode;
        }
        
        public Builder setDescrip(String descr){
            descrip=descr;
            return this;
        }
        
        public Builder setBrand(String br){
            brand=br;
            return this;
        }
        
        public Builder setSportswareList (List<sportware1> sportswareList){
            this.sportswareList = sportswareList;
            return this;
        }
        
        public Builder sportware(sportware1 wares){
            this.barcode = wares.barcode;
            this.brand = wares.brand;
            this.descrip = wares.descrip;
         this.id=wares.id;
            return this;
        }
        
        public sportware1 Build(){
            return new sportware1(this);
        }
        
        
    }

    @Override
    public String toString() {
        return "Sportware{"+ "id="+id+"}" ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
        {return false;}
        if(getClass()!= obj.getClass()){
            return false;
        }
        final sportware1 otherWare = (sportware1) obj;
        if(!Objects.equals(this.id,otherWare.id)){
            return false;
        }
        
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash =7;
        hash=53*hash+Objects.hashCode(this.id);
        return hash; //To change body of generated methods, choose Tools | Templates.
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
