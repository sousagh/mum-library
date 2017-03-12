package edu.mum.library.business;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.mum.library.data.impl.DataAccessObjectImpl;

public class CheckoutEntry implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -8270653102635166719L;
	private Publication publication;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date checkoutDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dueDate;

	/**
	 * Just for the use of Jackson API;
	 */
	public CheckoutEntry() {
	}

	public CheckoutEntry(Publication publication){
		this.publication=publication;
		publication.checkout();
		this.checkoutDate=new Date();
		int days=publication.getMaxDays();
		this.dueDate=new Date(System.currentTimeMillis()+(days*60*60*24*1000));
	}

	public Publication getPublication() {
		return this.publication;
	}
	public void setItem(Publication publication) {
		this.publication = publication;
	}
	public Date getCheckoutDate() {
		return this.checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public Date getDueDate() {
		return this.dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("[" + "checkoutdate:" );
		//sb.append(this.checkoutDate.format(DateTimeFormatter.ofPattern(DataAccessObjectImpl.DATE_PATTERN)));
		//sb.append(", dueDate: " + this.dueDate.format(DateTimeFormatter.ofPattern(DataAccessObjectImpl.DATE_PATTERN)));
		sb.append(", publication: " + this.publication + "]");
		return sb.toString();
	}


}
