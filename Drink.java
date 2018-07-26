/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itcrestaurant;

class Drink {
    public Drink()//constructor
        {
         
        }
     private String Drink, DrinkPrice;//variable declaration
 
     //getters and setters
     public String getDrink()
      {
         return Drink;
      }
     
     public String getDrinkPrice()
      {
         return DrinkPrice;
      }
    
     protected void setDrink(String iDrink)
      {
         this.Drink = iDrink;
      }
     
     protected void setDrinkPrice(String iDrinkPrice)
      {
         this.DrinkPrice = iDrinkPrice;
      }
}

