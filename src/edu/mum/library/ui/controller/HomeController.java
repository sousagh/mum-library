package edu.mum.library.ui.controller;

import java.io.IOException;
import java.util.List;

import edu.mum.library.business.Address;
import edu.mum.library.business.LibraryMember;
import edu.mum.library.business.bo.BookBO;
import edu.mum.library.business.bo.MemberBO;
import edu.mum.library.business.bo.PublicationBO;
import edu.mum.library.business.bo.impl.BusinessObjectFactory;
import edu.mum.library.ui.util.AppContext;
import edu.mum.library.ui.util.ResourceProvider;
import edu.mum.library.ui.util.SearchTableEntry;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

	private static final String BOOK = "Book";

	@FXML
	private RadioButton bookRadioButton;

	@FXML
	private RadioButton periodicRadioButton;

	@FXML
	private ToggleGroup group;

	@FXML
	private AnchorPane bookSearchPanel;

	@FXML
	private AnchorPane periodicSearchPanel;

	@FXML
	private TableView<SearchTableEntry> searchTable;

	@FXML
	private TableColumn<SearchTableEntry, String> itemInfoCol;

	@FXML
	private TableColumn<SearchTableEntry, String> itemNameCol;

	private ObservableList<SearchTableEntry> data;

	@FXML
	private TextField idMember;

	@FXML
	private TextField firstNameMember;

	@FXML
	private TextField lastNameMember;

	@FXML
	private TextField streetMember;

	@FXML
	private TextField cityMember;

	@FXML
	private TextField stateMember;

	@FXML
	private TextField zipCodeMember;

	@FXML
	private TextField phoneNumberMember;

	@FXML
	private TextField nameSearch;

	@FXML
	private TextField isbnSearch;

	@FXML
	private TextField authorSearch;

	@FXML
	private DatePicker dateSearch;

	@FXML
	public void initialize() {

		configureRadioButton();

		configureTable();

		this.idMember.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					HomeController.this.idMember.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
	}

	@FXML
	public void search() {
		RadioButton radioButton = (RadioButton) this.group.getSelectedToggle();
		List<SearchTableEntry> books = null;
		if (radioButton.getText().equals(BOOK)) {

			BookBO bookBO = (BookBO) BusinessObjectFactory.getBusinessObject(BookBO.class);
			books = bookBO.search(this.nameSearch.getText(), this.isbnSearch.getText(),
					this.authorSearch.getText());

		} else {
			PublicationBO periodicBO = (PublicationBO) BusinessObjectFactory.getBusinessObject(PublicationBO.class);
			books = periodicBO.search(this.nameSearch.getText(), this.dateSearch.getValue());
		}
		this.data = FXCollections.observableArrayList(books);
		this.searchTable.setItems(this.data);
	}

	private void configureTable() {
		this.itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		this.itemInfoCol.setCellValueFactory(new PropertyValueFactory<>("itemInfo"));

		this.data = FXCollections.observableArrayList();
		this.searchTable.setItems(this.data);

		this.searchTable.setRowFactory(tv -> {
			TableRow<SearchTableEntry> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					SearchTableEntry rowData = row.getItem();
					AppContext.putParam(AppContext.PUBLICATION, rowData);
					try {

						RadioButton radioButton = (RadioButton) this.group.getSelectedToggle();
						Parent root = null;
						if (radioButton.getText().equals(BOOK)) {
							root = FXMLLoader.load(ResourceProvider.getBook());
						} else{
							root = FXMLLoader.load(ResourceProvider.getPeriodic());
						}
						Stage stage = new Stage();
						stage.setTitle("Details");
						stage.setScene(new Scene(root));
						stage.show();

						System.out.println(rowData);
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			return row;
		});
	}

	private void configureRadioButton() {
		this.group = new ToggleGroup();
		this.bookRadioButton.setToggleGroup(this.group);
		this.periodicRadioButton.setToggleGroup(this.group);

		this.group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (HomeController.this.group.getSelectedToggle() != null) {
					RadioButton radioButton = (RadioButton) HomeController.this.group.getSelectedToggle();

					if (radioButton.getText().equals(BOOK)) {
						HomeController.this.bookSearchPanel.setVisible(true);
						HomeController.this.periodicSearchPanel.setVisible(false);
					} else {
						HomeController.this.bookSearchPanel.setVisible(false);
						HomeController.this.periodicSearchPanel.setVisible(true);
					}
				}
			}
		});

		this.bookRadioButton.setSelected(true);
	}

	@FXML
	public void addMember() {
		if (this.lastNameMember.getText().isEmpty() || this.idMember.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Member's Id and Last Name cannot be empty");
			alert.setContentText("Correct your data to proceed.");

			alert.showAndWait();
		} else {
			int zip=0;
			try{
				zip=Integer.parseInt(this.zipCodeMember.getText());
			}catch(Exception e){
				new Exception("Zip code must be an Integer");
			}
			Address address = new Address(this.streetMember.getText(),this.cityMember.getText(),this.stateMember.getText(),zip);
			LibraryMember member = new LibraryMember(new Integer(this.idMember.getText()),this.firstNameMember.getText(),this.lastNameMember.getText(),address,this.phoneNumberMember.getText());
			MemberBO memberBO = (MemberBO) BusinessObjectFactory.getBusinessObject(MemberBO.class);
			memberBO.addMember(member);

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Success!");
			alert.showAndWait();

			this.clearMemberTab();
		}
	}

	private void clearMemberTab() {
		this.firstNameMember.clear();
		this.lastNameMember.clear();
		this.idMember.clear();
		this.phoneNumberMember.clear();
		this.cityMember.clear();
		this.stateMember.clear();
		this.streetMember.clear();
		this.zipCodeMember.clear();
	}

}
