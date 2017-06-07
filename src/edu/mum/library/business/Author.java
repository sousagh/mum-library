package edu.mum.library.business;

import java.io.Serializable;

public class Author extends Person implements Serializable{

	private static final long serialVersionUID = 7318910697067633490L;
	public Author() {

	}

	private String credentials;
	private String bio;

	public Author(String name,String lastName,Address address,String phoneNumber,String cred,String bio){
		super(name,lastName,address,phoneNumber);
		this.credentials=cred;
		this.bio=bio;
	}

	public String getCredentials() {
		return this.credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getBio() {
		return this.bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString(){
		return this.name + " " + this.lastName + " - " + this.credentials;
	}
}
