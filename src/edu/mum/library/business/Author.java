package edu.mum.library.business;

public class Author extends Person{
	private String credentials;
	private String bio;
	
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
