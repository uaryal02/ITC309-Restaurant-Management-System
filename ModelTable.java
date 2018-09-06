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
    
    
String item,price,time;
int id,Table_Number;
private Button button;

private Button button1;



DBConnector db = new DBConnector();
int count = 0;
String number = new String();
TextField textField;



public ModelTable (String item, String price, String time){
    this.item = item;
    this.price = price;
 this.id = id;
    this.time = time;
    this.button = new Button("Add To Plate");
    this.button1 = new Button("DELETE");
    
    
    
    button.setOnAction(evt -> {
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
            stmt=connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS cart ( ID INT NOT NULL AUTO_INCREMENT,ITEM VARCHAR(45),PRICE VARCHAR(45),TIME VARCHAR(45),Table_Num int, PRIMARY KEY (ID),OrderNumber int);");
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
           
                  
        } catch (SQLException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
} );

    button1.setOnAction((ActionEvent evt) -> {
    try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
        stmt = connection.createStatement();
       
        stmt.execute("DELETE FROM cart WHERE ITEM = ('"+ModelTable.this.getItem()+"') AND Table_Num = ('"+ModelTable.this.getTableNumber()+"')") ;
        
        DBConnector.getConnection(); 
         stmt.close();
        
   }   catch (SQLException ex) {
        Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
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
//    for (int i=0;i<5;i++){
//    System.out.println(MacAddress);
//    }
        switch (MacAddress){
            case "BC-83-85-DA-92-D9":
            Table_Number = 1;                        
        }
	return Table_Number;
        
    }

public String getItem(){
    return item;
}
public String getPrice(){
    return price;
}

public Integer getId(){
    return id;
}
public String getTime(){
    return time;
}


public void setItem(String item){
    this.item = item;
}
public void setPrice(String price){
    this.price = price;
}

public void setId(Integer id){
    this.id = id;
}
public void setTime(String time){
    this.price = time;
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
        return "ModelTable { ID: "+this.id+",Item: " + this.item + ",  Price: " + this.price + ",Time: " + this.time + "}";
    }
    
    
   
    
    
    
}