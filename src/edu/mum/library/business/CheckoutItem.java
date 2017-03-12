package edu.mum.library.business;

import java.io.Serializable;

public class CheckoutItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Publication publication;
	private int copyId;
	private boolean isAvailable;
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Publication getPublication() {
		return publication;
	}
	 
	CheckoutItem(Publication pub,int copyId){
		this.publication=pub;
		this.copyId=copyId;
		this.isAvailable=true;
	}
	
	
	
	public int getCopyId() {
		return copyId;
	}
	
	public void setCopyId(int copyId){
		this.copyId=copyId;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String toString() {
		return publication.toString();
	}
}
