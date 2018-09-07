/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsoftware;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static restaurantsoftware.DBConnector.stmt;

/**
 * FXML Controller class
 *
 * @author kiran_000
 */
public class StaffLoginController implements Initializable {

    @FXML
    private Button Login;

    
    @FXML
	private TextField username;

	@FXML
	private PasswordField password;

    Stage dialogStage = new Stage();
    Scene scene;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
    private Button cancel;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void login(ActionEvent event) {
        
      
     String Password = password.getText().toString();
      String Username = username.getText().toString();
 password.setVisible(true);
  username.setText(null);
  
      String sql = "SELECT * FROM staff WHERE username = ? and password = ?";
       try {
           password.setText(null);
        username.setText(null);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1991");
        stmt=connection.createStatement();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Username);
        preparedStatement.setString(2, Password);
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            //System.out.println"Enter Correct Email and Password", "Failed", null;
            JOptionPane.showMessageDialog(null, " incorrect username and password");
        } else {
          //  infoBox("Login Successfull", "Success", null);
            Node source = (Node) event.getSource();
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Staff.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        }

    } catch (Exception e) {
        e.printStackTrace();
        
        
    }
    }

    @FXML
    private void cancelButton(ActionEvent event) {
         Platform.exit();
        System.exit(0);
    }
       
         
   
    
}
