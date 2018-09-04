package restaurantsoftware;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.S;
import javafx.stage.Stage;
import static restaurantsoftware.DBConnector.stmt;
/**
 * FXML Controller class
 *
 * @author kiran_000
 */
public class EditMenuController1 implements Initializable {

    @FXML
    private Button addButton1;
    @FXML
    private Button editButton1;
    @FXML
    private Button updateButton1;
    @FXML
    private Button deleteButton1;
    @FXML
    private Button clearButton1;
    @FXML
    private Button addButton2;
    @FXML
    private Button editButton2;
    @FXML
    private Button updateButton2;
    @FXML
    private Button deleteButton2;
    @FXML
    private Button clearButton2;
   
    
    @FXML
    private TableView<ModelTable> EntreeTable;
    
    
    @FXML
    private TableColumn<ModelTable, String> EPrice;
    
    @FXML
    private TableColumn<ModelTable, String> EItem;
    
    @FXML
    private TableColumn<ModelTable, Integer> EId;
    @FXML
    private TableColumn<ModelTable, String> ETime;
   
    
    @FXML
    private TableView<ModelTable> MainTable;
    @FXML
    private TableColumn<ModelTable, String> MItem;
    @FXML
    private TableColumn<ModelTable, String> MPrice;
     @FXML
    private TableColumn<ModelTable, Integer> MId;
    @FXML
    private TableColumn<ModelTable, String> MTime;
    
    
    
    @FXML
    private TableView<ModelTable> DessertTable;
    @FXML
    private TableColumn<ModelTable, String> DItem;
    @FXML
    private TableColumn<ModelTable, String> DPrice;
    @FXML
    private TableColumn<ModelTable, Integer> DId;
    @FXML
    private TableColumn<ModelTable, String> DTime;
    
   
    
     
    @FXML
    private Button deleteButton3;
    
    @FXML
    private Button addButton3;
    @FXML
    private Button editButton3;
    @FXML
    private Button updateButton3;
    @FXML
    private Button clearButton3;
    @FXML
    private TextField EntreePriceField;
    @FXML
    private TextField EntreeNameField;
    
    @FXML
    private TextField MainPriceField;
    @FXML
    private TextField DessertPriceField;
    
    
    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist1 = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist2 = FXCollections.observableArrayList();
    
     @FXML
    private TextField MainNameField;
    @FXML
    private TextField DessertNameField;
   @FXML
    private TextField MainIdField;
    @FXML
    private TextField MainTimeField;
    @FXML
    private TextField DessertIdField;
    @FXML
    private TextField DessertTimeField;
    @FXML
    private Button backButton;
    @FXML
    private TextField EntreeIDField;
    @FXML
    private TextField EntreeTimeField;
    
    Connection connection;
    
    
    //tray notification variables
    String focus = "ITEM DATA";
    String detail;
    MessageNotification messageNotification = new MessageNotification();
   
    
    
   public EditMenuController1() {
    } 
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
        EId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        MItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        MPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        MId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        DItem.setCellValueFactory(new PropertyValueFactory<>("item"));
        DPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        DId.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        
        
        
        EntreeTable.setItems(oblist);
        MainTable.setItems(oblist1);
        DessertTable.setItems(oblist2);
        
        
        
        
        
        
       
    }    

    
    
    @FXML
    public void addAction(){
        addButton1.setOnAction(evt -> {
        
       try{
       
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
            stmt=connection.createStatement();
            stmt.execute("INSERT INTO entree (ITEM_NAME,PRICE,time_req)VALUES ('"+EntreeNameField.getText()+"','"+EntreePriceField.getText()+"','"+EntreeTimeField.getText()+"')");
             
            stmt.close();
               messageNotification.addSuccessTrayNotification(focus, detail);
       // oblist.add(new ModelTable(EntreeNameField.getText(), EntreePriceField.getText()));
      // String query = new String("INSERT INTO entree (id,ITEM_NAME,PRICE,time_req)VALUES ('"+EntreeIDField.getText()+"','"+EntreeNameField.getText()+"','"+EntreePriceField.getText()+",'"+EntreeTimeField.getText()+"'')");
     //stmt.execute(query);
     DBConnector.getConnection();
      //DBConnector.write(query);
       } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            messageNotification.addErrorTrayNotification(focus);
        } 
          }); 
          
       
          addButton2.setOnAction(evt -> {
        
       try{
        //Connection con = DBConnector.getConnection();
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
            stmt=connection.createStatement();
             stmt.execute("INSERT INTO main (item_name,price,time_req)VALUES ('"+MainNameField.getText()+"','"+MainPriceField.getText()+"','"+MainTimeField.getText()+"')");
             stmt.close();
              messageNotification.addSuccessTrayNotification(focus, detail);
         } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            messageNotification.addErrorTrayNotification(focus);
        } 
          }); 
          
          
          addButton3.setOnAction(evt -> {
        
       try{
        //Connection con = DBConnector.getConnection();
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
            stmt=connection.createStatement();
             stmt.execute("INSERT INTO dessert (item_name,price,time_req)VALUES ('"+DessertNameField.getText()+"','"+DessertPriceField.getText()+"','"+DessertTimeField.getText()+"')");
             stmt.close();
              messageNotification.addSuccessTrayNotification(focus, detail);
         } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            messageNotification.addErrorTrayNotification(focus);
        } 
          }); 
          
          
          
    }

    
    
    //populate gui fields based on user selection of table row
    @FXML
    public void editAction(ActionEvent event) {
        
        
        
         editButton1.setOnAction(evt -> {
        //if selection of table is empty
        if (EntreeTable.getSelectionModel().isEmpty()) {
            //select last row
            EntreeTable.getSelectionModel().selectLast();
        }

        //fill up gui text fields via table selection of user
        selectTableRowSetGuiTextFields();

        //enable button
        updateButton1.setDisable(false);

        //disable button
        addButton1.setDisable(true);
        deleteButton1.setDisable(true);
        resetFields();
                 
                  }); 
         
         
         editButton2.setOnAction(evt -> {
        //if selection of table is empty
        if (MainTable.getSelectionModel().isEmpty()) {
            //select last row
            MainTable.getSelectionModel().selectLast();
        }

        //fill up gui text fields via table selection of user
        selectTableRowSetGuiTextFields();

        //enable button
        updateButton2.setDisable(false);

        //disable button
        addButton2.setDisable(true);
        deleteButton2.setDisable(true);
        resetFields();
                 
                  }); 
         
    }

    //Delete an sales data with a given sales Id from DB
    @FXML
    public void deleteAction(){
        
         deleteButton1.setOnAction((ActionEvent evt) -> {
    try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
            stmt=connection.createStatement();
            
        String removedName = oblist.get(EntreeTable.getSelectionModel().getSelectedIndex()).getItem();
			oblist.remove(EntreeTable.getSelectionModel().getSelectedIndex());
			String query = new String("DELETE FROM entree WHERE ITEM_NAME = '"+removedName+"';");
                        stmt.execute(query);
                        DBConnector.getConnection(); 
                    //DBConnector.write(query);
        
}   catch (Exception ex) {
        Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
    }
    });

         
         deleteButton2.setOnAction((ActionEvent evt) -> {
    try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
            stmt=connection.createStatement();
            
        String removedName = oblist1.get(MainTable.getSelectionModel().getSelectedIndex()).getItem();
			oblist1.remove(MainTable.getSelectionModel().getSelectedIndex());
			String query = new String("DELETE FROM main WHERE item_name = '"+removedName+"';");
                        stmt.execute(query);
                        DBConnector.getConnection(); 
                    //DBConnector.write(query);
        
}   catch (Exception ex) {
        Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
    }
    });
      
         
         deleteButton3.setOnAction((ActionEvent evt) -> {
    try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
            stmt=connection.createStatement();
            
        String removedName = oblist2.get(DessertTable.getSelectionModel().getSelectedIndex()).getItem();
			oblist2.remove(DessertTable.getSelectionModel().getSelectedIndex());
			String query = new String("DELETE FROM dessert WHERE item_name = '"+removedName+"';");
                        stmt.execute(query);
                        DBConnector.getConnection(); 
                    //DBConnector.write(query);
        
}   catch (Exception ex) {
        Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
    }
    });



    }

    
    
     private ModelTable createSalesDataFromGuiFields() {
        //only extract id from combo box selection      
        String Item = EntreeNameField.getText().toString();
        String Price = EntreePriceField.getText().toString();
       // String Id = EntreeIDField.getText().toString();
        String Time = EntreeTimeField.getText().toString();
        
        String Item1 = MainNameField.getText().toString();
        String Price1 = MainPriceField.getText().toString();
        //String Id1 = MainIdField.getText().toString();
        String Time1 = MainTimeField.getText().toString();
        
        String Item3 = DessertNameField.getText().toString();
        String Price3 = DessertPriceField.getText().toString();
        //String Id3 = DessertIdField.getText().toString();
        String Time3 = DessertTimeField.getText().toString();
        
        //sets data to ObservableList based on columns from database
        ModelTable item = new ModelTable();
        item.setItem(Item);
        item.setPrice(Price);
        //item.setId(Id);
        item.setTime(Time);
        
        item.setItem(Item1);
        item.setPrice(Price1);
       // item.setId(Id1);
        item.setTime(Time1);
        
        item.setItem(Item3);
        item.setPrice(Price3);
        //item.setId(Id3);
        item.setTime(Time3);
        
       return item;
    }

    
    
    
    
    //Update sales data with edited data from gui text fields
    @FXML
    public void updateSalesDataAction(ActionEvent event) throws SQLException, ClassNotFoundException {
       updateButton1.setOnAction((ActionEvent evt) -> {
           
           PreparedStatement preparedStatement = null;

        //Declare a UPDATE statement
        String updateQuery
                = " UPDATE entree set \n"
               // + " id = ?, \n "
                + " ITEM_NAME = ?, \n "
                + " PRICE = ?, \n "
                + " time_req = ? ";

        try {
           preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, EntreeTable.getId());
           
            preparedStatement.executeUpdate();

            
        }  catch (Exception ex) {
        Logger.getLogger(ModelTable.class.getName()).log(Level.SEVERE, null, ex);
    }
         });
    }

    @FXML
    public void clearAction(ActionEvent event) {
        //clear gui text fuilds
        resetFields();

        //enable button
        addButton1.setDisable(false);
        deleteButton1.setDisable(false);
        addButton2.setDisable(false);
        deleteButton2.setDisable(false);
        addButton3.setDisable(false);
        deleteButton3.setDisable(false);
    }

    //*************************************
    //Support Functions for FXML
    //*************************************    
    
   

    //Populate SalesData for TableView
    private void populateItems(ObservableList<ModelTable> items) throws ClassNotFoundException {
        //Set items to the salesDataTable
        EntreeTable.setItems(items);
         MainTable.setItems(items);
          DessertTable.setItems(items);
    }

    //fill up gui text fields via table selection of user
    private void selectTableRowSetGuiTextFields() {
          EntreeNameField.setText(EntreeTable.getItems().get(EntreeTable.getSelectionModel().getSelectedIndex()).getItem());
        EntreePriceField.setText(EntreeTable.getItems().get(EntreeTable.getSelectionModel().getSelectedIndex()).getPrice().toString());
    MainNameField.setText(MainTable.getItems().get(MainTable.getSelectionModel().getSelectedIndex()).getItem());
        MainPriceField.setText(MainTable.getItems().get(MainTable.getSelectionModel().getSelectedIndex()).getPrice().toString());
        DessertNameField.setText(DessertTable.getItems().get(DessertTable.getSelectionModel().getSelectedIndex()).getItem());
        DessertPriceField.setText(DessertTable.getItems().get(DessertTable.getSelectionModel().getSelectedIndex()).getPrice().toString());
            
    }

    

    //if empty set gui text fields null or 0
    private void setDefaultGuiTextFields() {
        

        if (EntreeNameField.getText() == null || EntreeNameField.getText().trim().isEmpty()) {
            EntreeNameField.setText("Item Name !");
        }

        if (EntreePriceField.getText() == null || EntreePriceField.getText().trim().isEmpty()) {
            EntreePriceField.setText("0.0");
        }
        if (MainNameField.getText() == null || MainNameField.getText().trim().isEmpty()) {
            MainNameField.setText("Item Name !");
        }

        if (MainPriceField.getText() == null || MainPriceField.getText().trim().isEmpty()) {
            MainPriceField.setText("0.0");
        }
         if (DessertNameField.getText() == null || DessertNameField.getText().trim().isEmpty()) {
            DessertNameField.setText("Item Name !");
        }

        if (DessertPriceField.getText() == null || DessertPriceField.getText().trim().isEmpty()) {
            DessertPriceField.setText("0.0");
        }

    }

    private void resetFields() {
        EntreePriceField.setText("");
        EntreePriceField.setText("0.0");
        
        
    }

    @FXML
    private void updateAction(ActionEvent event) {
    }

    @FXML
    private void backtoMain(ActionEvent event) {
        
        System.out.println("Kiran");
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
            Scene scene = new Scene(root1,1200,1200);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
            stage1.setMaximized(true);
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    
        
        
    }
