package edu.mum.library.business;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
	private List<CheckoutEntry> entries;
	
	public CheckoutRecord(){
		this.entries=new ArrayList<CheckoutEntry>();
	}

	public List<CheckoutEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<CheckoutEntry> entries) {
		this.entries = entries;
	}
	
	public void addCheckoutEntry(CheckoutEntry entry){
		this.entries.add(entry);
	}
	
	
}
