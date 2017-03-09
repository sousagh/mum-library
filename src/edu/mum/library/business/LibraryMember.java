package edu.mum.library.business;

public class LibraryMember extends Person{
	private int memberNumber;
	private CheckoutRecord record;

	public LibraryMember(int num,String name,String lastName,Address address,String phoneNumber){
		this.memberNumber=num;
		this.name=name;
		this.lastName=lastName;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.record=new CheckoutRecord();
	}
	
	public CheckoutRecord getRecord() {
		return record;
	}

	public void setRecord(CheckoutRecord record) {
		this.record = record;
	}
	
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	public String toString(){
		return memberNumber+", "+super.toString();
	}
}
