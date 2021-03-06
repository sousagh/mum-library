package edu.mum.library.ui.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.mum.library.business.LibraryMember;
import edu.mum.library.business.Publication;
import edu.mum.library.business.Role;
import edu.mum.library.business.User;
import edu.mum.library.business.bo.MemberBO;
import edu.mum.library.business.bo.PublicationBO;
import edu.mum.library.business.bo.impl.BusinessObjectFactory;
import edu.mum.library.ui.util.AppContext;
import edu.mum.library.ui.util.SearchTableEntry;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PeriodicController {

	@FXML
	private Label namePeriodic;

	@FXML
	private Label datePeriodic;

	@FXML
	private Label availability;

	@FXML
	private Button checkoutButton;

	@FXML
	private TextField memberId;

	Publication publication;

	@FXML
	private Text memberLabel;

	@FXML
	public void initialize() {
		configureTextFields();

		User user = (User) AppContext.getParam(AppContext.USER);

		if (user.getRole().equals(Role.ADMINISTRATOR)) {
			this.checkoutButton.setVisible(false);
			this.memberId.setVisible(false);
			this.memberLabel.setVisible(false);
		}
		SearchTableEntry entry = (SearchTableEntry) AppContext.getParam(AppContext.PUBLICATION);
		PublicationBO periodicBO = (PublicationBO) BusinessObjectFactory.getBusinessObject(PublicationBO.class);

		this.publication = periodicBO.findById(entry.getId());

		this.namePeriodic.setText(this.publication.getTitle());
		Date date = this.publication.getDate();

		this.datePeriodic.setText(new SimpleDateFormat().format(date));

		this.availability.setText(new Boolean(this.publication.isAvailable()).toString());

		if (!this.publication.isAvailable()) {
			this.checkoutButton.setDisable(true);
		} else {
			this.checkoutButton.setDisable(false);
		}

	}

	@FXML
	public void checkout(ActionEvent event) {
		if (validateMemberId()) {
			MemberBO memberBO = (MemberBO) BusinessObjectFactory.getBusinessObject(MemberBO.class);

			if (!memberBO.exists(Integer.parseInt(this.memberId.getText()))) {

				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Validation Error");
				alert.setContentText("Member does not exist.");
				alert.showAndWait();

				this.memberId.clear();
			} else {
				LibraryMember member=memberBO.findById(this.memberId.getText());
				memberBO.checkout(member,this.publication);
				this.memberId.clear();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Successful checkout!");
				alert.showAndWait();
				Node node=(Node)event.getSource();
				Scene scene=node.getScene();
				scene.getWindow().hide();
			}

		}
	}

	private boolean validateMemberId() {
		StringBuilder builder = new StringBuilder();
		if (this.memberId.getText().isEmpty()) {
			builder.append("ID cannot be empty. \n");
		}
		try{
			Integer.getInteger(this.memberId.getText());
		}catch(Exception e){
			builder.append("ID must be an Integer. \n");
		}

		boolean valid = builder.toString().isEmpty();
		if (!valid) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validation Error");
			alert.setContentText(builder.toString());
			alert.showAndWait();
		}

		return valid;
	}

	private void configureTextFields() {
		this.memberId.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					PeriodicController.this.memberId.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

	}


}