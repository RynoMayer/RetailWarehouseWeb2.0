/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryno.retailwarehouseweb.domain;

/**
 *
 * @author ryno
 */
public final class Item {
    private String barcode;
    private String type;
            
    
    public String getBarcode(){
        return barcode;
    }
    public String getType(){
        return type;
    }
    
    private Item(ItemBuilder builder){
        barcode=builder.barcode;
    }
    
    public static class ItemBuilder{
        private String barcode;
        private String type;
        
        public ItemBuilder(String bcode){
            this.barcode=bcode;
        }
        
        public ItemBuilder setType(String types){
            this.type=types;
            return this;
        }
        
        public Item build(){
            return new Item(this);
        }
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.barcode != null ? this.barcode.hashCode() : 0);
        hash = 67 * hash + (this.type != null ? this.type.hashCode() : 0);
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
        final Item other = (Item) obj;
        if ((this.barcode == null) ? (other.barcode != null) : !this.barcode.equals(other.barcode)) {
            return false;
        }
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        return true;
    }
}
