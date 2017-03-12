package edu.mum.library.business;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CheckoutItem implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonBackReference
	private Publication publication;
	private int copyId;
	private boolean isAvailable;

	public CheckoutItem() {
	}

	public boolean isAvailable() {
		return this.isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public Publication getPublication() {
		return this.publication;
	}

	CheckoutItem(Publication pub,int copyId){
		this.publication = pub;
		this.copyId=copyId;
		this.isAvailable=true;
	}



	public int getCopyId() {
		return this.copyId;
	}

	public void setCopyId(int copyId){
		this.copyId=copyId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	// @Override
	// public String toString() {
	// return this.publication.toString();
	// }
}
