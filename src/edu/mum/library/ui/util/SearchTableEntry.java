package edu.mum.library.ui.util;

import java.text.SimpleDateFormat;

import edu.mum.library.business.Book;
import edu.mum.library.business.Publication;
import javafx.beans.property.SimpleStringProperty;

public class SearchTableEntry {

	private String id;
	private SimpleStringProperty itemName;
	private SimpleStringProperty itemInfo;

	public SearchTableEntry(String id, String name, String info) {
		this.itemName = new SimpleStringProperty(name);
		this.itemInfo = new SimpleStringProperty(info);
		this.setId(id);
	}

	public SearchTableEntry(Book book) {
		this(book.getIsbn(), book.getTitle(), book.getAuthors().toString());
	}

	public SearchTableEntry(Publication object) {
		this(new Integer(object.hashCode()).toString(), object.getTitle(),
				new SimpleDateFormat().format(object.getDate()));
	}

	public String getItemName() {
		return this.itemName.getValueSafe();
	}

	public void setItemName(String itemName) {
		this.itemName.set(itemName);
	}

	public String getItemInfo() {
		return this.itemInfo.getValueSafe();
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo.set(itemInfo);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
