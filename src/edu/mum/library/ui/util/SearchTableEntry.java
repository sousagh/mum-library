package edu.mum.library.ui.util;

import javafx.beans.property.SimpleStringProperty;

public class SearchTableEntry {

	public SearchTableEntry(String name, String info) {
		this.itemName = new SimpleStringProperty(name);
		this.itemInfo = new SimpleStringProperty(info);
	}
	private SimpleStringProperty itemName;
	private SimpleStringProperty itemInfo;

	public String getItemName() {
		return this.itemName.getValueSafe() + "!";
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

}
