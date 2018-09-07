/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsoftware;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author kiran_000
 */
public class Staff {
   
    private SimpleLongProperty id;
   
    private SimpleStringProperty userName;
    private SimpleStringProperty password;

    public Staff() {
        this.id = new SimpleLongProperty();
        
        this.userName = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
    }

    public Staff(Long id, String userName, String password) {
        this.id.set(id);
       
        this.userName.set(userName);
        this.password.set(password);
    }

    public Long getId() {
        return id.get();
    }

   

    public String getUserName() {
        return userName.get();
    }

    public String getPassword() {
        return password.get();
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    
    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public SimpleLongProperty Id() {
        return id;
    }

  
    public SimpleStringProperty UserName() {
        return userName;
    }

    public SimpleStringProperty Password() {
        return password;
    }

    public void setId(SimpleLongProperty id) {
        this.id = id;
    }

   
    public void setUserName(SimpleStringProperty userName) {
        this.userName = userName;
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{ID: " + this.id.get() + ", UserName " + this.userName.get() + ", Password: " + password.get() + "}";
    }

    
    
    
}
