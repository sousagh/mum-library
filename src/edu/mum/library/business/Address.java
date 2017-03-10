package edu.mum.library.business;

public class Address {
	private String zipCode;
	private String state;
	private String city;
	private String street;

	public Address(String street,String city,String state,String zipCode){
		this.city=city;
		this.street=street;
		this.state=state;
		this.zipCode=zipCode;
	}

	public Address() {
	}

	public String getZipCode() {
		return this.zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return this.street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString(){
		return this.street+"\n"+this.city+","+this.state+","+this.zipCode;
	}
}
