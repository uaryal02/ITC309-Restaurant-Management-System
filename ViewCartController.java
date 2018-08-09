package restaurantsoftware;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import restaurantsoftware.DBConnector;
import restaurantsoftware.ModelTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josar
 */
public class ViewCartController implements Initializable {
    @FXML
    private TableView<ModelTable> cartTable;
    @FXML
    private TableColumn <ModelTable,String> itemColumn;
    @FXML
    private TableColumn <ModelTable,String> priceColumn;
    
    ObservableList<ModelTable> oblist3 = FXCollections.observableArrayList();
    
      
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
        Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from cart");
            while (rs.next()){
                oblist3.add(new ModelTable(rs.getString("Item"),rs.getString("Price")));
            }
    }   catch (SQLException ex) {
            Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        cartTable.setItems(oblist3);
}
}
