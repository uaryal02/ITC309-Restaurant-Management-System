/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsoftware;

/**
 *
 * @author Josar
 */
public class ModelTable {
    
String item,price;

public ModelTable (String item, String price){
    this.item = item;
    this.price = price;
}
public String getItem(){
    return item;
}
public String getPrice(){
    return price;
}
public void setItem(String item){
    this.item = item;
}
public void setPrice(String price){
    this.price = price;
}
}

