package edu.mum.library.business;

public abstract class Person {
	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(firstName+" "+lastName);
		return sb.toString();
	}
	
}
