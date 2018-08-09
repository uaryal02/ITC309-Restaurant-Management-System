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
import java.lang.String;
import static java.sql.JDBCType.INTEGER;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Josar
 */
public class FXMLDocumentController implements Initializable {

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
    @FXML
    //public TextField textField;
    //ModelTable mt = new ModelTable()

    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist1 = FXCollections.observableArrayList();
    ObservableList<ModelTable> oblist2 = FXCollections.observableArrayList();
    
      
    
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
                
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
        
        DessertTable.getColumns().addAll (AddToCart);
        EntreeTable.getColumns().addAll (AddToCart2);
        MainTable.getColumns().addAll (AddToCart3);
       
         
        
        try{
        Connection con = DBConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from entree");
            ResultSet rs1 = con.createStatement().executeQuery("select * from main");
            ResultSet rs2 = con.createStatement().executeQuery("select * from dessert");
            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("Item"),rs.getString("Price")));
            }
            while (rs1.next()){
                oblist1.add(new ModelTable(rs1.getString("Item"),rs1.getString("Price")));
            }
            while (rs2.next()){
                oblist2.add(new ModelTable(rs2.getString("Item"),rs2.getString("Price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
        //textField.setText(getText());

    }    
    
            
    
}