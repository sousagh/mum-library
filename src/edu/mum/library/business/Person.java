package edu.mum.library.business;

import java.io.Serializable;

public abstract class Person implements Serializable{

	private static final long serialVersionUID = 8664466430169843435L;
	protected String name;
	protected String lastName;
	protected Address address;
	protected String phoneNumber;

	public Person(String name,String lastName,Address address,String phoneNumber){
		this.name=name;
		this.lastName=lastName;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}

	public Person() {
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return this.address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(this.name+" "+this.lastName);
		return sb.toString();
	}

}
