package edu.mum.library.ui.controller;

import java.io.IOException;

import edu.mum.library.business.User;
import edu.mum.library.business.bo.LoginBO;
import edu.mum.library.business.bo.impl.BusinessObjectFactory;
import edu.mum.library.ui.util.ResourceProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

		LoginBO loginBo = (LoginBO) BusinessObjectFactory.getBusinessObject(LoginBO.class);

		User user = loginBo.login(this.userName.getText(), this.password.getText());
		if (user != null) {
			showHome(event);
		} else {
			this.loginMessage.setVisible(true);
		}

	}

	private void showHome(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(ResourceProvider.getHome());

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
