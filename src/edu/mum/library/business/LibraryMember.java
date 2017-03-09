package edu.mum.library.business;

public class LibraryMember extends Person{
	private int memberNumber;

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
