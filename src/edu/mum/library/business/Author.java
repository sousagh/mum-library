package edu.mum.library.business;

import java.io.Serializable;

public class Author extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7318910697067633490L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String credentials;
	private String bio;
	
	public Author(String name,String lastName,Address address,String phoneNumber,String cred,String bio){
		super(name,lastName,address,phoneNumber);
		this.credentials=cred;
		this.bio=bio;
	}
	
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public String toString(){
		return super.toString()+"\n"+credentials+"\n"+bio;
	}
}
