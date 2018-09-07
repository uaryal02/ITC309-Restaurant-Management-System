/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsoftware;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import static restaurantsoftware.DBConnector.stmt;



/**
 *
 * @author Josar
 */
public class ModelTable {

    static void insertItem(ModelTable createSalesDataFromGuiFields) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    static ObservableList<Item> searchItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
String item;

Long id;
Double price;
Integer time, Table_Number;

private Button button;

private Button button1;



DBConnector db = new DBConnector();
int count = 0;
String number = new String();
TextField textField;



public ModelTable (Long id, String item, Double price, Integer time){
    this.item = item;
    this.price = price;
    this.id = id;
    this.time = time;
    this.button = new Button("Add To Plate");
    this.button1 = new Button("DELETE");
    
    
    
    button.setOnAction(evt -> {
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1991");
            stmt=connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS cart ( ID BIGINT(45) NOT NULL AUTO_INCREMENT,ITEM VARCHAR(45),PRICE DOUBLE,TIME INTEGER(45), Table_Num INT, PRIMARY KEY(ID),OrderNumber int);");
            stmt.close();
            stmt=connection.createStatement();
            stmt.execute ("INSERT INTO cart(ITEM,PRICE,TIME,Table_Num) VALUES ('"+ModelTable.this.getItem()+"','"+ModelTable.this.getPrice()+"','"+ModelTable.this.getTime()+"','"+ModelTable.this.getTableNumber()+"')");
            stmt.close();
            stmt=connection.createStatement();
            ResultSet rs = db.stmt.executeQuery("SELECT * FROM cart");
            while (rs.next()){
                count++;
                
            }
            number = Integer.toString(count);
            //textField.setText("100");
            stmt.close();
            
           
            JOptionPane.showMessageDialog(null, "Added ");       
        } catch (SQLException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, " Not Added ");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
} );

    button1.setOnAction((ActionEvent evt) -> {
    try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1991");
        stmt = connection.createStatement();
       		
        stmt.execute("DELETE FROM cart WHERE ITEM = ('"+ModelTable.this.getItem()+"') AND Table_Num = ('"+ModelTable.this.getTableNumber()+"')") ;
        
        DBConnector.getConnection(); 
         stmt.close();
         JOptionPane.showMessageDialog(null, "Deleted ");
   }   catch (SQLException ex) {
        Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null, "Not Deleted ");
    }   catch (UnknownHostException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    });


   


   
    
    
    
}

    ModelTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static int getTableNumber() throws UnknownHostException, SocketException{
    InetAddress ip;
    int Table_Number=0;
    ip = InetAddress.getLocalHost();
    NetworkInterface network = NetworkInterface.getByInetAddress(ip);
    byte[] mac = network.getHardwareAddress();
    StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
    String MacAddress = sb.toString();
    System.out.println (MacAddress);
//    for (int i=0;i<5;i++){
//    System.out.println(MacAddress);
//    }
        switch (MacAddress){
            case "BC-83-85-DA-92-D9":
            Table_Number = 1;   
            
            case "00-50-56-C0-00-08":
                Table_Number = 2;
        }
	return Table_Number;
        
    }
    
    
    
    
public String getItem(){
    return item;
}
public Double getPrice(){
    return price;
}

public Long getId(){
    return id;
}
public Integer getTime(){
    return time;
}


public void setItem(String item){
    this.item = item;
}
public void setPrice(Double price){
    this.price = price;
}

public void setId(Long id){
    this.id = id;
}
public void setTime(Integer time){
    this.time = time;
}

public Button getButton(){
    return button;
}

public Button getButton1(){
    return button1;
}



public String getString(){
    return number;
}
public void setString(String number){
    this.number = number;
}


public void setButton(Button button){
    this.button = button;
}

public void setButton1(Button button1){
    this.button = button1;
}


   
     @Override
    public String toString() {
        return "ModelTable { Id: " + this.id + ",Item: " + this.item + ",  Price: " + this.price + ",Time: " + this.time + "}";
    }
    
    
    
    
}

