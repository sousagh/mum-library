package edu.mum.library.ui.controller;

import edu.mum.library.business.Book;
import edu.mum.library.business.LibraryMember;
import edu.mum.library.business.Role;
import edu.mum.library.business.User;
import edu.mum.library.business.bo.BookBO;
import edu.mum.library.business.bo.MemberBO;
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

public class BookController {

	@FXML
	private Label availableCopies;

	@FXML
	private Label nameBook;

	@FXML
	private Label isbnBook;

	@FXML
	private Label authorBook;

	@FXML
	private Button checkoutButton;

	@FXML
	private TextField memberId;

	@FXML
	private Button addCopyButton;

	@FXML
	private Label memberLabel;

	private Book book;

	@FXML
	public void initialize() {
		configureTextFields();
		User user = (User) AppContext.getParam(AppContext.USER);

		if (user.getRole().equals(Role.ADMINISTRATOR)) {
			this.checkoutButton.setVisible(false);
			this.memberId.setVisible(false);
			this.memberLabel.setVisible(false);
		}
		if (user.getRole().equals(Role.LIBRARIAN)) {
			this.addCopyButton.setVisible(false);
		}

		SearchTableEntry entry = (SearchTableEntry) AppContext.getParam(AppContext.PUBLICATION);

		BookBO bookBO = (BookBO) BusinessObjectFactory.getBusinessObject(BookBO.class);

		this.book = bookBO.findById(entry.getId());

		int availableCopies2 = this.book.getAvailableCopies();
		this.availableCopies.setText(new Integer(availableCopies2).toString());
		this.nameBook.setText(this.book.getTitle());
		this.isbnBook.setText(this.book.getIsbn());
		this.authorBook.setText(this.book.getAuthors().toString());

		if (availableCopies2 < 1) {
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

			} else {
				LibraryMember member=memberBO.findById(this.memberId.getText());
				memberBO.checkout(member,this.book);
				showSuccessMessage();
				hideWindow(event);
			}
			this.memberId.clear();

		}
	}


	private void hideWindow(ActionEvent event) {
		Node node=(Node)event.getSource();
		Scene scene=node.getScene();
		scene.getWindow().hide();
	}


	private void showSuccessMessage() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Successful checkout!");
		alert.showAndWait();
	}

	@FXML
	public void addCopy(ActionEvent event) {
		BookBO bookBO = (BookBO) BusinessObjectFactory.getBusinessObject(BookBO.class);
		bookBO.addCopy(this.book);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText("Copy added successfully!");
		alert.showAndWait();
		initialize();
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
					BookController.this.memberId.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

	}
}
