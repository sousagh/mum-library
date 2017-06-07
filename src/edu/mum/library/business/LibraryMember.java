package edu.mum.library.business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {
	private static final long serialVersionUID = -1457880329095768495L;
	private int memberNumber;
	private CheckoutRecord record;

	public LibraryMember(int num,String name,String lastName,Address address,String phoneNumber){
		super(name,lastName,address,phoneNumber);
		this.memberNumber=num;
		this.record=new CheckoutRecord();
	}

	public LibraryMember() {

	}

	public CheckoutRecord getRecord() {
		return this.record;
	}

	public void setRecord(CheckoutRecord record) {
		this.record = record;
	}

	public int getMemberNumber() {
		return this.memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	@Override
	public String toString(){
		return this.memberNumber+", "+super.toString();
	}

	public String print() {
		StringBuilder builder = new StringBuilder();
		builder.append("================================================================\n");

		builder.append("Name: ").append(this.name).append(" ").append(this.lastName).append("\n");
		builder.append("Member ID: ").append(this.memberNumber).append("\n");
		builder.append("Phone: ").append(this.phoneNumber).append("\n");
		builder.append(this.record.print());
		return builder.toString();
	}
}
