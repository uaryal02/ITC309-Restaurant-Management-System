package restaurantsoftware;
import javafx.scene.control.Button;
/**
 *
 * @author Josar
 */
public class ModelTable {
    
String item,price;
private Button button;
public ModelTable (String item, String price){
    this.item = item;
    this.price = price;
   this.button = new Button("AddToCart");
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

