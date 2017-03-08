package edu.mum.library.ui.controller;

import java.io.IOException;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
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
	public void initialize() {

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

		this.itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
		this.itemInfoCol.setCellValueFactory(new PropertyValueFactory<>("itemInfo"));

		this.data = FXCollections.observableArrayList();

		this.data.add(new SearchTableEntry("qwwnM", "INFO"));
		this.data.add(new SearchTableEntry("nMwwqwq", "INFO"));
		this.data.add(new SearchTableEntry("gustavo", "INFO"));

		this.searchTable.setItems(this.data);

		this.searchTable.setRowFactory(tv -> {
			TableRow<SearchTableEntry> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					SearchTableEntry rowData = row.getItem();
					AppContext.putParam("book", rowData);
					try {

						RadioButton radioButton = (RadioButton) this.group.getSelectedToggle();
						Parent root = null;
						if (radioButton.getText().equals(BOOK)) {
							root = FXMLLoader.load(ResourceProvider.getBook());
						} else{
							root = FXMLLoader.load(ResourceProvider.getPeriodic());
						}
						Stage stage = new Stage();
						stage.setTitle("Book");
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

}
