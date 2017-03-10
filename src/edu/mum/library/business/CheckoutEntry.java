package edu.mum.library.business;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.mum.library.data.impl.DataAccessObjectImpl;

public class CheckoutEntry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8270653102635166719L;
	private CheckoutItem item;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	public CheckoutEntry(CheckoutItem item, LocalDate dueDate){
		this.item=item;
		this.checkoutDate=LocalDate.now();
		this.dueDate=dueDate;
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
		sb.append("[" + "checkoutdate:" );
		sb.append(checkoutDate.format(DateTimeFormatter.ofPattern(DataAccessObjectImpl.DATE_PATTERN)));
		sb.append(", dueDate: " + dueDate.format(DateTimeFormatter.ofPattern(DataAccessObjectImpl.DATE_PATTERN)));
		sb.append(", publication: " + item + "]");
		return sb.toString();
	}
	
	
}
