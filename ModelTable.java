package restaurantsoftware;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static restaurantsoftware.DBConnector.stmt;
/**
 *
 * @author Josar
 */
public class ModelTable {
    
String item,price;
public Button button;
//final TableCell cell = new TableCell();
DBConnector db = new DBConnector();
int count = 0;
String number = new String();
TextField textField;

public ModelTable (String item, String price){
    this.item = item;
    this.price = price;
   this.button = new Button("Add To Plate");
   
   
button.setOnAction(evt -> {
        try {
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/softwaredatabase","root","1995");
            stmt=connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS cart ( ITEM VARCHAR(45),PRICE VARCHAR(45));");
            stmt.close();
            stmt=connection.createStatement();
            stmt.execute ("INSERT INTO cart(ITEM,PRICE) VALUES ('"+ModelTable.this.getItem()+"','"+ModelTable.this.getPrice()+"')");
            stmt.close();
            stmt=connection.createStatement();
            ResultSet rs = db.stmt.executeQuery("SELECT * FROM cart");
            while (rs.next()){
                count++;
                
            }
            number = Integer.toString(count);
            textField.setText("10");
            stmt.close();
           
                  
        } catch (SQLException ex) {
            Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
});
   
}

    ModelTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

public Button getButton(){
    return button;
}

public void setButton(Button button){
    this.button = button;
}

public String getString(){
    return number;
}
public void setString(String number){
    this.number = number;
}

}

