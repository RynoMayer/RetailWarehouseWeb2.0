/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryno.retailwarehouseweb.domain;

/**
 *
 * @author ryno
 */
public class stationary implements IProduct{
    private String barcode;
    private String descrip;
    private String brand;
    
    private stationary(){}
    
    public String Types(){
        return "stationary";
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
    
    private stationary(Builder build){
        barcode=build.barcode;
    }
    
    public static class Builder{
        private String barcode;
        private String descrip;
        private String brand;    
    
        public Builder(String bcode){
            this.barcode=bcode;
        }
        
        public Builder descrip(String descr){
            descrip=descr;
            return this;
        }
        
        public Builder brand(String br){
            brand=br;
            return this;
        }
        
        public stationary Build(){
            return new stationary(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.barcode != null ? this.barcode.hashCode() : 0);
        hash = 29 * hash + (this.descrip != null ? this.descrip.hashCode() : 0);
        hash = 29 * hash + (this.brand != null ? this.brand.hashCode() : 0);
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
        final stationary other = (stationary) obj;
        if ((this.barcode == null) ? (other.barcode != null) : !this.barcode.equals(other.barcode)) {
            return false;
        }
        if ((this.descrip == null) ? (other.descrip != null) : !this.descrip.equals(other.descrip)) {
            return false;
        }
        if ((this.brand == null) ? (other.brand != null) : !this.brand.equals(other.brand)) {
            return false;
        }
        return true;
    }
    
}
