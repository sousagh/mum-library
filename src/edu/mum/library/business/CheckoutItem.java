package edu.mum.library.business;

import java.io.Serializable;

public class CheckoutItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Publication publication;
	private int copyId;
	
	public int getCopyId() {
		return copyId;
	}
	
	public void setCopyId(int copyId){
		this.copyId=copyId;
	}
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String toString() {
		return publication.toString();
	}
}
