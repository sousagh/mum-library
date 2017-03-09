package edu.mum.library.ui.controller;

import edu.mum.library.business.Book;
import edu.mum.library.business.bo.BookBO;
import edu.mum.library.business.bo.impl.BusinessObjectFactory;
import edu.mum.library.ui.util.AppContext;
import edu.mum.library.ui.util.SearchTableEntry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

	private Book book;

	@FXML
	public void initialize() {
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
}
