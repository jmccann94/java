package application.controller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class mainMenuController {
	
	/*
	 * fxml variables and class variables
	 * go here
	 */
	
	public void handle(ActionEvent event) {
		/*
		 * 
		 */
		
		
		// Redirect user to next view - fightScreen
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/fightScreen.fxml"));
			Main.stage.setScene(new Scene(root, 800, 600));
			Main.stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
