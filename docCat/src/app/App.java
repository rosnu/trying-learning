package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class App {

	@FXML
	Button but;

	@FXML
	private void initialize(){
		System.out.println("initialized");
	}

	@FXML
	private void butAction(){
		System.out.println("butAction");
	}


}
