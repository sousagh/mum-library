package edu.mum.library.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable{
	private static final long serialVersionUID = -5271994822901888472L;
	private List<CheckoutEntry> entries;

	public CheckoutRecord(){
		this.entries=new ArrayList<CheckoutEntry>();
	}

	public List<CheckoutEntry> getEntries() {
		return this.entries;
	}

	public void setEntries(List<CheckoutEntry> entries) {
		this.entries = entries;
	}

	public void addCheckoutEntry(CheckoutEntry entry){
		this.entries.add(entry);
	}


}
