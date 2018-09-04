package restaurantsoftware;

/**
 *
 * @author kiran_000
 */




import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class Item {

    //private SimpleStringProperty id;
    private SimpleStringProperty ITEM_NAME;
    private SimpleStringProperty PRICE;
    private SimpleStringProperty time_req;

    public Item() {
        //this.id = new SimpleStringProperty();
        this.ITEM_NAME = new SimpleStringProperty();
        this.PRICE = new SimpleStringProperty();
        this.time_req = new SimpleStringProperty();
    }

    public Item(String id,String ITEM_NAME , String PRICE,String time_req) {
        this.ITEM_NAME = new SimpleStringProperty(ITEM_NAME);
        this.PRICE = new SimpleStringProperty(PRICE);
       // this.id = new SimpleStringProperty(id);
        this.time_req = new SimpleStringProperty(time_req);
        
    }

    
    public String getName() {
        return ITEM_NAME.get();
    }

    

    public String getPrice() {
        return PRICE.get();
    }

//     public String getId() {
//        return id.get();
//    }

    

    public String getTime() {
        return time_req.get();
    }
   

   public void setName(String name) {
        this.ITEM_NAME.set(name);
    }
   
    public void setPrice(String Price) {
        this.PRICE.set(Price);
    }
  
//    public void setId(String id) {
//        this.id.set(id);
//    }
   
    public void setTime(String time) {
        this.time_req.set(time);
    }

   

    public SimpleStringProperty Name() {
        return ITEM_NAME;
    }

    

    public SimpleStringProperty Price() {
        return PRICE;
    }
    
    public SimpleStringProperty Time() {
        return time_req;
    }

    

//    public SimpleStringProperty Id() {
//        return id;
//    }

   

    public void setName(SimpleStringProperty name) {
        this.ITEM_NAME = name;
    }

    
    public void setPrice(SimpleStringProperty price) {
        this.PRICE = price;
    }
    
//    public void setId(SimpleStringProperty id) {
//        this.id = id;
//    }

    
    public void setTime(SimpleStringProperty time) {
        this.time_req = time;
    }

//    @Override
//    public String toString() {
//        return "Item {  Id : " + this.id.get() + " ,Name : " + this.ITEM_NAME.get() + " ,PRICE: " + this.PRICE.get()+ " , Time : " + this.time_req.get()+ "}";
//    }

    void insertItem(ModelTable createSalesDataFromGuiFields) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ObservableList<ModelTable> searchItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}