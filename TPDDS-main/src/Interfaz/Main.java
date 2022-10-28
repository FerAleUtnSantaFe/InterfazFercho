package Interfaz;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception{

		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("MainSB.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Capit@l humano - Nuevo Puesto");
			//stage.setResizable(false);
			//stage.setFullScreen(true);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public static void main(String[] args) {
		launch(args);
	}
}
