package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {

		try {
//			Parent parent = FXMLLoader.load(getClass().getResource("App.fxml"));
//			Scene scene = new Scene(parent);
//			stage.setScene(scene);
//			stage.show();


			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("App.fxml"));
//			fxmlLoader.setRoot(new ArchorPane());
			fxmlLoader.load();

			Scene scene = new Scene(fxmlLoader.getRoot(),640,360);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			App controller = (App) fxmlLoader.getController();

//			controller.setScene(scene);
//			controller.sceneAddEventFilter();

		} catch(Exception e) {
			e.printStackTrace();
		}

//shutdown all threads
	    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        @Override
	        public void handle(WindowEvent e) {
	           Platform.exit();
	           System.exit(0);
	        }
	     });

	}

	public static void main(String[] args) {
		launch(args);
	}


}
