package restaurantsoftware;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList; 

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import javafx.scene.control.SplitPane;
import javafx.stage.StageStyle;

/**
 *
 * @author kiran_000
 */
public class RestaurantSoftware1 extends Application {
    
   public static ArrayList<Stage> stages = new ArrayList<Stage>();
   public static ArrayList<Scene> scenes = new ArrayList<Scene>();
   @Override
    public void start(Stage stage) throws Exception {
        
	/*	
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        */
        
       Stage mainStage = new Stage();
		mainStage.setTitle("Project");
		
		stages.add(mainStage);
                mainStage.setMaximized(true);
                mainStage.initStyle(StageStyle.UTILITY);
		
		
		

		try {
			FXMLLoader FXMLDocument = new FXMLLoader(RestaurantSoftware1.class.getResource("FXMLDocument_1.fxml"));
			
			SplitPane FXMLDocumentPage = (SplitPane) FXMLDocument.load();
			
			Scene FXMLDocumentScene = new Scene(FXMLDocumentPage);
			
			scenes.add(FXMLDocumentScene);//0
			

			mainStage.setScene(FXMLDocumentScene);
			mainStage.show();

		} catch (IOException e) {
			System.err.println("Error!");
			e.printStackTrace();
} 
        
        
        
        
        
    }//

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    //asdas
    
}