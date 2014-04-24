/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryno.retailwarehouseweb.domain;

/**
 *
 * @author ryno
 */
public class Electronics implements IProduct{
    private String barcode;
    private String descrip;
    private String brand;
    
    public String Types(){
        return "electronic";
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
    
    private Electronics(Builder build){
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
        
        public Electronics Build(){
            return new Electronics(this);
        }
    }
}
