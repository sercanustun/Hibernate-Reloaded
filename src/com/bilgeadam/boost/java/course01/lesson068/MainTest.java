package com.bilgeadam.boost.java.course01.lesson068;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainTest extends Application {
	public static void main(String... args) {
		
		launch(args);
		// MovieEntityController movieController = new MovieEntityController();
		//
		// MovieEntity movieEntity = movieController.find(60756);
		// for (MovieEntity movieEntity : movieEntities) {
		// System.out.println(movieEntity);
		// }
		
		// UserEntityController userController = new UserEntityController();
		// UserEntity userEntity = userController.find(15);
		// System.out.println(userEntity);
	}
	
	@Override
	public void start(Stage primary) throws Exception {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("view/main/MainView.fxml"));
			Scene scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("view/main/application.css").toExternalForm());
			primary.setScene(scene);
			primary.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}