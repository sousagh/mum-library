package edu.mum.library.business;

public abstract class Person {
	protected String name;
	protected String lastName;
	protected Address address;
	protected String phoneNumber;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		sb.append(name+" "+lastName);
		return sb.toString();
	}
	
}
