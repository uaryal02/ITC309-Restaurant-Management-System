package restaurantsoftware;

import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kiran_000
 */
public class OrderController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private TableView<ModelTable> cartTable;
    @FXML
    private TableView<ModelTable> ordertable;
    @FXML
    private TableColumn<ModelTable, String> Orderid;
    @FXML
    private TableColumn<ModelTable, String> Item;
    @FXML
    private TableColumn<ModelTable, String> Price;
    @FXML
    private TableColumn<ModelTable, String> Time;

    ObservableList<ModelTable> oblist3 = FXCollections.observableArrayList();
    
     @FXML
    private Button backCart;
    @FXML
    private AnchorPane backToCart;
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try{
        Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from cart WHERE Table_Num = ('"+ModelTable.getTableNumber()+"')") ;
            while (rs.next()){
                oblist3.add(new ModelTable(rs.getString("Item"),rs.getString("Price"),rs.getString("Time")));
            }

            
            
    }   catch (SQLException ex) {
            Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Orderid.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Item.setCellValueFactory(new PropertyValueFactory<>("Item"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Time"));
        
        
        
         
        ordertable.setItems(oblist3);
        
    }    

    @FXML
    private void backtoMain(ActionEvent event) {
        
        System.out.println("Sarthak");
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
            Scene scene = new Scene(root1,1200,1200);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
//
//    
//
    @FXML
    private void backtoCart(ActionEvent event) {
        System.out.println("Sarthak");
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("ViewCart1.fxml"));
            Scene scene = new Scene(root1,1200,800);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
    }

    
    
}