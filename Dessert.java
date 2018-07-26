/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itcrestaurant;

class Dessert {
    public Dessert()//constructor
    {
        
    }
    
    private String Dessert, DessertPrice;//variable declaration
    
    
    //getters and setters
    public String getDessert()
      {
         return Dessert;
      }
     
    public String getDessertPrice()
      {
         return DessertPrice;
      }
    
      protected void setDessert(String iDessert)
      {
         this.Dessert = iDessert;
      }
     
     protected void setDessertPrice(String iDessertPrice)
      {
         this.DessertPrice = iDessertPrice;
      }
     
    
}


