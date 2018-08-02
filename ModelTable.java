package restaurantsoftware;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
/**
 *
 * @author Josar
 */
public class ModelTable {
    
String item,price;
public Button button;
final TableCell cell = new TableCell();

public ModelTable (String item, String price){
    this.item = item;
    this.price = price;
   this.button = new Button("Add To Plate");
   
   
button.setOnAction(evt -> {
    TableRow row = cell.getTableRow();
    System.out.println(row.getItem());
});
   
}

public String getItem(){
    return item;
}
public String getPrice(){
    return price;
}


public void setItem(String item){
    this.item = item;
}
public void setPrice(String price){
    this.price = price;
}

public Button getButton(){
    return button;
}

public void setButton(Button button){
    this.button = button;
}


}

