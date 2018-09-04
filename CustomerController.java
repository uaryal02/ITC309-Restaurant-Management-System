package restaurantsoftware;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kiran_000
 */
public class CustomerController implements Initializable {

   
    /**
     * Initializes the controller class.
     */
    
    
     @FXML
    private TableView<ModelTable> EntreeTable;
    @FXML
    private TableColumn<ModelTable, String> EItem;
    @FXML
    private TableColumn<ModelTable, String> EPrice;
    @FXML
    private TableView<ModelTable> MainTable;
    @FXML
    private TableColumn<ModelTable, String> MItem;
    @FXML
    private TableColumn<ModelTable, String> MPrice;
    @FXML
    private TableView<ModelTable> DessertTable;
    @FXML
    private TableColumn<ModelTable, String> DItem;
    @FXML
    private TableColumn<ModelTable, String> DPrice;
//    private TableColumn<ModelTable,Integer> EId;
//    private TableColumn<ModelTable,Integer> MId;
//    private TableColumn<ModelTable,Integer> DId;
    
    
    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist1 = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist2 = FXCollections.observableArrayList();
    
    private ObservableList<ModelTable> cartData = FXCollections.observableArrayList();  
    @FXML
    private TextField search;
    @FXML
    private Button PLACEANORDER;
    @FXML
     Button viewCart;
    @FXML
    private Button EditMenu;
   
    
    
    @FXML
    private void viewCartButton(ActionEvent event){
       Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("ViewCart1.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("My New Stage Title");
            stage1.setScene(new Scene(root1, 1000, 800));
            stage1.show();
            stage1.setMaximized(true);
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
}
    
    
   @FXML
    private void EditMenuButton(ActionEvent event){
       Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("EditMenu.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("My New Stage Title");
            stage1.setScene(new Scene(root1, 1200, 800));
            stage1.show();
            stage1.setMaximized(true);
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
}
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
        
        TableColumn AddToCart = new TableColumn("Action");
        AddToCart.setPrefWidth(100);
        AddToCart.setResizable(false);
        
        TableColumn AddToCart2 = new TableColumn("Action");
        AddToCart2.setPrefWidth(100);
         AddToCart2.setResizable(false);
        TableColumn AddToCart3= new TableColumn("Action");
        AddToCart3.setPrefWidth(100);
         AddToCart3.setResizable(false);
         AddToCart3.impl_setReorderable(false);
           AddToCart2.impl_setReorderable(false);
             AddToCart3.impl_setReorderable(false);
        
        EntreeTable.getColumns().addAll (AddToCart);
        MainTable.getColumns().addAll (AddToCart2);
        DessertTable.getColumns().addAll (AddToCart3);
       

        
        
        
        
        
        
         
        
        try{
        Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from entree");
            ResultSet rs1 = con.createStatement().executeQuery("select * from main");
            ResultSet rs2 = con.createStatement().executeQuery("select * from dessert");
            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("ITEM_NAME"),rs.getString("PRICE"),rs.getString("time_req")));
            }
            while (rs1.next()){
                oblist1.add(new ModelTable(rs1.getString("item_name"),rs1.getString("price"),rs1.getString("time_req")));
            }
            while (rs2.next()){
                oblist2.add(new ModelTable(rs2.getString("item_name"),rs2.getString("price"),rs2.getString("time_req")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        EPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
         MItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        MPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
         DItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        DPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
//        EId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        MId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        DId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        
        
        AddToCart.setCellValueFactory(new PropertyValueFactory<>("button"));
        AddToCart2.setCellValueFactory(new PropertyValueFactory<>("button"));
        AddToCart3.setCellValueFactory(new PropertyValueFactory<>("button"));
        
        
        
        EntreeTable.setItems(oblist);
        MainTable.setItems(oblist1);
        DessertTable.setItems(oblist2);
        
        
    }    

    @FXML
    private void showDetails(ActionEvent event) {
    }

    @FXML
    private void searchOnKeyPressed(KeyEvent event) {
    }

    
}