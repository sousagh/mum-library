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

	/**
	 * Just for the use of Jackson API;
	 */
	public CheckoutEntry() {
	}

	public CheckoutEntry(CheckoutItem item){
		this.item=item;
		this.checkoutDate=LocalDate.now();
		// int days=this.item.getPublication().getMaxDays();
		// this.dueDate=this.checkoutDate.plusDays(days);
	}

	public CheckoutItem getItem() {
		return this.item;
	}
	public void setItem(CheckoutItem item) {
		this.item = item;
	}
	public LocalDate getCheckoutDate() {
		return this.checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public LocalDate getDueDate() {
		return this.dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("[" + "checkoutdate:" );
		sb.append(this.checkoutDate.format(DateTimeFormatter.ofPattern(DataAccessObjectImpl.DATE_PATTERN)));
		sb.append(", dueDate: " + this.dueDate.format(DateTimeFormatter.ofPattern(DataAccessObjectImpl.DATE_PATTERN)));
		sb.append(", publication: " + this.item + "]");
		return sb.toString();
	}


}
