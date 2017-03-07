package edu.mum.library.ui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField userName;

	@FXML
	private TextField password;

	@FXML
	private Text loginMessage;

	@FXML
	public void login(ActionEvent event) throws IOException {
		if (this.userName.getText().equals("user") && this.password.getText().equals("123")) {

			Button button = (Button) event.getSource();
			Stage stage = (Stage) button.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("/edu/mum/library/ui/Home.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			System.out.println(this.userName.getText() + " - " + this.password.getText());
			this.loginMessage.setVisible(true);
		}

		// public void pressButton(ActionEvent event) throws Exception {
		// try {
		// FXMLLoader fxmlLoader = new
		// FXMLLoader(getClass().getResource("/fxml/A.fxml"));
		// Parent root1 = (Parent) fxmlLoader.load();
		// Stage stage = new Stage();
		// stage.setScene(new Scene(root1));
		// stage.show();
		// } catch(Exception e) {
		// e.printStackTrace();
		// }
		// }
	}
}
