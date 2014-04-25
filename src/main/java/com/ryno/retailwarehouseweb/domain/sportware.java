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

//@SuppressWarnings("ConsistentAccessType")
@Entity
public class sportware implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String barcode;
    private String descrip;
    private String brand;
    //@OneToMany (cascade = CascadeType.ALL)
    //@JoinColumn (name="sportware_id")
    //List<sportware> sportswareList;

    public Long getId() {
        return id;
    }
    
    
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
    
    
    private sportware(){};
   
    
    private sportware(Builder build){
        this.barcode=build.barcode;
        this.brand = build.brand;
        this.descrip = build.descrip;
        this.id = build.id;
    }
    
    private sportware(sportware item){
        this.barcode = item.barcode;
        this.brand = item.brand;
        this.descrip = item.descrip;
        this.id = item.id;
    }
     
    
       /* public List<sportware> getSportswareList()
        {
            return sportswareList;
        }*/
    
    public static class Builder{
        private String barcode;
        private String descrip;
        private String brand;    
        private Long id;
        //List<sportware> sportswareList;
        
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
        
        /*public Builder setSportswareList (List<sportware> sportswareList){
            this.sportswareList = sportswareList;
            return this;
        }*/
        
        public Builder sportware(sportware wares){
            this.barcode = wares.barcode;
            this.brand = wares.brand;
            this.descrip = wares.descrip;
            this.id=wares.id;
            return this;
        }
        
        public sportware Build(){
            return new sportware(this);
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
        final sportware otherWare = (sportware) obj;
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

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
    
    
}
