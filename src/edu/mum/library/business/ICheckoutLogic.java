package edu.mum.library.business;

import java.util.HashMap;

public interface ICheckoutLogic {
	public CheckoutItem search(HashMap<String,Object> params);
	public void addNewCopy(String isbn);
	public void checkout(CheckoutItem item);
	public int getCopies(Book item);
	public void addBook(Book book);
	public CheckoutRecord getMemberHistoricRecord(LibraryMember member);
}
