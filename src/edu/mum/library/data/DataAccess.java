package edu.mum.library.data;

import java.util.List;

import edu.mum.library.business.Book;
import edu.mum.library.business.CheckoutEntry;
import edu.mum.library.business.LibraryMember;

public interface DataAccess {
	
	public void saveLibraryMember(int memberNumber,LibraryMember member);
	public LibraryMember readLibraryMember(int memberNumber);
	public List<LibraryMember> readLibraryMembers();
	public List<Book> readAllBooks();
	public List<CheckoutEntry> readAllCheckoutEntries();
	
}
