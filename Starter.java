/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itcrestaurant;

public class Starter {
    
    public Starter(){//constructor
        
    }
    //variable declarations
    private String Starter, StarterPrice;
    
    //getters and setters
    public String getStarter()
      {
         return Starter;
      }
     
     public String getStarterPrice()
      {
         return StarterPrice;
      }
     
     protected void setStarter(String iStarter)
      {
         this.Starter = iStarter;
      }
     
     protected void setStarterPrice(String iStarterPrice)
      {
         this.StarterPrice = iStarterPrice;
      }
}
