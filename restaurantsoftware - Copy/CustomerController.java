/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsoftware;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import static jdk.nashorn.internal.objects.NativeString.search;

/**
 * FXML Controller class
 *
 * @author kiran_000
 */
public class CustomerController implements Initializable {

   
    
    
    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist1 = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist2 = FXCollections.observableArrayList();
    
    private ObservableList<ModelTable> cartData = FXCollections.observableArrayList();  
    @FXML
    Button viewCart;
    @FXML
    private Button StaffLogin;
    @FXML
    private Button cancel;
    @FXML
    private TextField search;
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
    private TextField searchMain;
    @FXML
    private TableView<ModelTable> DessertTable;
    @FXML
    private TableColumn<ModelTable, String> DItem;
    @FXML
    private TableColumn<ModelTable, String> DPrice;
    @FXML
    private TextField searchDessert;
   
    
    
    @FXML
    private void viewCartButton(ActionEvent event){
       Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("ViewCart1.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("My New Stage Title");
            stage1.setScene(new Scene(root1, 1000, 800));
            stage1.show();
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
                oblist.add(new ModelTable(rs.getLong("id"),rs.getString("ITEM_NAME"),rs.getDouble("PRICE"),rs.getInt("time_req")));
            }
            while (rs1.next()){
                oblist1.add(new ModelTable(rs1.getLong("id"),rs1.getString("item_name"),rs1.getDouble("price"),rs1.getInt("time_req")));
            }
            while (rs2.next()){
                oblist2.add(new ModelTable(rs2.getLong("id"),rs2.getString("item_name"),rs2.getDouble("price"),rs2.getInt("time_req")));
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
        
        
        AddToCart.setCellValueFactory(new PropertyValueFactory<>("button"));
        AddToCart2.setCellValueFactory(new PropertyValueFactory<>("button"));
        AddToCart3.setCellValueFactory(new PropertyValueFactory<>("button"));
        
        
        
        EntreeTable.setItems(oblist);
        MainTable.setItems(oblist1);
        DessertTable.setItems(oblist2);
        
        
    }    


    @FXML
    private void searchOnKeyPressed(KeyEvent event) {
        
        FilteredList<ModelTable> filteredData = new FilteredList<>(oblist, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(ModelTable -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                 if (ModelTable.getItem().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                
                return false; // Does not match.
            });
        });
        
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<ModelTable> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(EntreeTable.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        EntreeTable.setItems(sortedData);
    }
   
        
        
    

    @FXML
    private void staffLogin(ActionEvent event) {
      Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("StaffLogin.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("My New Stage Title");
            stage1.setScene(new Scene(root1, 800, 600));
            stage1.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }  
        
    }

    @FXML
    private void searchOnKeyMain(KeyEvent event) {
        
        FilteredList<ModelTable> filteredData = new FilteredList<>(oblist1, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        searchMain.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(ModelTable -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (ModelTable.getItem().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                
                return false; // Does not match.
            });
        });
        
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<ModelTable> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(MainTable.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        MainTable.setItems(sortedData);
    }

    @FXML
    private void searchOnKeyDessert(KeyEvent event) {
        FilteredList<ModelTable> filteredData = new FilteredList<>(oblist2, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        searchDessert.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(ModelTable -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (ModelTable.getItem().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                
                return false; // Does not match.
            });
        });
        
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<ModelTable> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(DessertTable.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        DessertTable.setItems(sortedData);
        
    }

    @FXML
    private void cancelButton(ActionEvent event) {
        
         Platform.exit();
        System.exit(0);
    }


    

    
}
