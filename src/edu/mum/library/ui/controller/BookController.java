package edu.mum.library.ui.controller;

import edu.mum.library.ui.util.AppContext;
import edu.mum.library.ui.util.SearchTableEntry;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookController {

	

	@FXML
	public void initialize() {
		SearchTableEntry entry = (SearchTableEntry) AppContext.getParam("book");
//		this.bookInfo.setText(entry.getItemInfo());
//		this.bookName.setText(entry.getItemName());
//		this.label.setText(entry.getItemInfo() + "  Gustavo");
	}
}
