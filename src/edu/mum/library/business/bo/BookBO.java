package edu.mum.library.business.bo;

import java.util.List;

import edu.mum.library.business.Book;
import edu.mum.library.ui.util.SearchTableEntry;

public interface BookBO {

	List<SearchTableEntry> search(String name, String isbn, String author);

	Book findById(String string);

	List<SearchTableEntry> findAll();
	
	void addCopy(Book book);
}
