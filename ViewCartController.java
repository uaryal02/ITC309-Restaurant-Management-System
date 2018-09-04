package restaurantsoftware;

import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
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
import javafx.stage.Stage;
import restaurantsoftware.DBConnector;
import static restaurantsoftware.DBConnector.stmt;
import restaurantsoftware.ModelTable;

/**
 * FXML Controller class
 *
 * @author kiran_000
 */
public class ViewCartController implements Initializable {
    

   @FXML
    private TableView<ModelTable> cartTable;
    @FXML
    private TableColumn <ModelTable,String> itemColumn;
    @FXML
    private TableColumn <ModelTable,String> priceColumn;
    @FXML
    private TableColumn<ModelTable, String> idColumn;
    @FXML
    private TableColumn<ModelTable, String> timeColumn;
    
    ObservableList<ModelTable> oblist3 = FXCollections.observableArrayList();
    
     @FXML
Button backButton;
    @FXML
    private Button PlaceOrder;
     
     
     
     @FXML
    private void backtoMain(ActionEvent event){
        
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
    
    
//    public void refreshTable(){
//        oblist3.clear();
//        try{
//        Connection con = DBConnector.getConnection();
//            ResultSet rs = con.createStatement().executeQuery("select * from cart");
//            while (rs.next()){
//                 oblist3.add(new ModelTable(rs.getString("Id"),rs.getString("Item"),rs.getString("Price"),rs.getString("Time")));
//            }
//    }   catch (SQLException ex) {
//            Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        cartTable.setItems(oblist3);
//}
   
    public void initialize(URL url, ResourceBundle rb) {
       try {
           Connection c = DBConnector.getConnection();
           DatabaseMetaData dbm = c.getMetaData();
           ResultSet tables =  dbm.getTables(null,null,"cart",null);
           if(tables.next()){
              TableColumn Delete = new TableColumn("Action");
        Delete.setPrefWidth(100);
        Delete.setResizable(false);
         Delete.setCellValueFactory(new PropertyValueFactory<>("button1"));
         cartTable.getColumns().addAll (Delete);
        
        
        try{
        Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from cart WHERE Table_Num = ('"+ModelTable.getTableNumber()+"')") ;
            ResultSet rs1 = rs;
            if (rs.next()){
            while (rs1.next()){
                oblist3.add(new ModelTable(rs1.getString("Item"),rs1.getString("Price"),rs1.getString("Time")));
            }
            cartTable.setItems(oblist3);
            }
            
    }   catch (SQLException ex) {
            Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
        }      catch (UnknownHostException ex) { 
                   Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SocketException ex) {
                   Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
               } 
           }
           else{System.out.println("No cart table found");
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        
        
        
        
        
        
}

    @FXML
    private void PlaceOrder(ActionEvent event) throws SQLException, UnknownHostException{ 
        Parent root1;
        try {
            root1 = FXMLLoader.load(getClass().getResource("Order.fxml"));
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
        Connection c = DBConnector.getConnection();
        DatabaseMetaData dbm = c.getMetaData();
        ResultSet tables = dbm.getTables("menu", null, "orderTable", null);
        if (tables.next()){
            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
               stmt=connection.createStatement();
              // stmt.execute("CREATE TABLE orderTable LIKE cart");
               stmt.execute ("INSERT INTO orderTable(ITEM,PRICE,TIME,Table_Num) SELECT ITEM,PRICE,TIME,Table_Num FROM cart WHERE Table_Num = ('"+ModelTable.getTableNumber()+"')") ;
               stmt.execute("DROP TABLE menu.cart");
               stmt.close();
            } 
            catch(SQLException E){
                Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, E);
            } catch (SocketException ex) {
                Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else{
            System.out.println("Order table does not exist");
            try{
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/menu","root","1995");
               stmt=connection.createStatement();
               stmt.execute("CREATE TABLE orderTable (ID int NOT NULL AUTO_INCREMENT, ITEM varchar(50),PRICE varchar(40),TIME varchar(40),Table_Num int,PRIMARY KEY(ID));");
               stmt.execute ("INSERT INTO orderTable(ITEM,PRICE,TIME,Table_Num) SELECT ITEM,PRICE,TIME,Table_Num FROM cart WHERE Table_Num = ('"+ModelTable.getTableNumber()+"')") ;
               stmt.execute("DROP TABLE menu.cart");
               stmt.close();
            }
            catch (SQLException ex) {
               Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SocketException ex) {
                Logger.getLogger(ViewCartController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
}
}
   