/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsoftware;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kiran_000
 */
public class StaffController implements Initializable {

    @FXML
    private Button EditMenu;
    @FXML
    private Button DeleteOrder;
    @FXML
    private Button Logout;
    @FXML
    private Button ChangePassword;
    @FXML
    private Button ViewHomePage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void editMenu(ActionEvent event) {
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("EditMenu.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("My New Stage Title");
            stage1.setScene(new Scene(root1, 1200, 800));
            stage1.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteOrder(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
         System.exit(0);
    }

    @FXML
    private void changePassword(ActionEvent event) {
        
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("Password.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("My New Stage Title");
            stage1.setScene(new Scene(root1, 700, 600));
            stage1.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void viewHomePage(ActionEvent event) {
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
            Stage stage1 = new Stage();
            stage1.setTitle("My New Stage Title");
            stage1.setScene(new Scene(root1, 1200, 800));
            stage1.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
