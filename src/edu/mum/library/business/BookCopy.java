package edu.mum.library.business;

import java.io.Serializable;


public class BookCopy implements Serializable{
	private static final long serialVersionUID = 1L;

	private int copyId;
	private boolean isAvailable;

	public BookCopy() {
	}

	public boolean isAvailable() {
		return this.isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	BookCopy(int copyId){
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
