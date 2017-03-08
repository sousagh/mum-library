package edu.mum.library.business;

import java.time.LocalDate;

public class CheckoutEntry {
	private LibraryMember member;
	private CheckoutItem item;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	public CheckoutEntry(LibraryMember member,CheckoutItem item, LocalDate dueDate){
		this.member=member;
		this.item=item;
		this.checkoutDate=LocalDate.now();
		this.dueDate=dueDate;
	}
	
	public LibraryMember getMember() {
		return member;
	}
	public void setMember(LibraryMember member) {
		this.member = member;
	}
	public CheckoutItem getItem() {
		return item;
	}
	public void setItem(CheckoutItem item) {
		this.item = item;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(this.item.toString()+" - ");
		sb.append(this.member.getMemberNumber()+", "+ this.member.getName()+" "+this.member.getLastName()+" - ");
		sb.append(this.checkoutDate.toString() +" - ");
		sb.append(this.dueDate.toString()+"\n");
		return sb.toString();
	}
	
	
}
