/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static restaurantsoftware.DBConnector.stmt;

/**
 *
 * @author kiran_000
 */
public class PasswordController {

    @FXML
    private Button ChangePassword;
    @FXML
    private TextField password;
    
    
    
     Stage dialogStage = new Stage();
    Scene scene;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private TextField username;

    @FXML
    private void changePassword(ActionEvent event) {
        String Username = username.getText().toString();
         String Password = password.getText().toString();
         String sql = "UPDATE  staff   WHERE username =? SET password = ?";
       try {
           password.setText(null);
       
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1991");
        stmt=connection.createStatement();
        preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setString(1, Username);
        preparedStatement.setString(2, Password);
        //resultSet = preparedStatement.executeQuery();
        stmt.executeUpdate(sql);
        if (!resultSet.next()) {
            //System.out.println"Enter Correct Email and Password", "Failed", null;
        } else {
          //  infoBox("Login Successfull", "Success", null);
            
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
        
    }

    
}
