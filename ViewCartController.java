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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private TableView cartTable;
    @FXML
    private TableColumn <ModelTable,String> itemColumn;
    @FXML
    private TableColumn <ModelTable,String> priceColumn;
    @FXML
    Button backButton;
    ObservableList<ModelTable> oblist3 = FXCollections.observableArrayList();
    
    @FXML
    private void backtoMain(ActionEvent event){
        System.out.println("Sarthak");
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root1,900,870);
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
