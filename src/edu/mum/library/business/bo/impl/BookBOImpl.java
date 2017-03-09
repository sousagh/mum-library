package edu.mum.library.business.bo.impl;

import java.util.ArrayList;
import java.util.List;

import edu.mum.library.business.bo.BookBO;
import edu.mum.library.ui.util.SearchTableEntry;

public class BookBOImpl implements BookBO {

	BookBOImpl() {
	}

	@Override
	public List<SearchTableEntry> search(String name, String isbn, String author) {

		List<SearchTableEntry> books = new ArrayList<>();

		books.add(new SearchTableEntry("1", "Lord Of the Rings", "ISBN 213131 Author: J. Tolkien"));
		books.add(new SearchTableEntry("2", "Design Patterns", "ISBN 32442 Author: Marting Fowler"));
		books.add(new SearchTableEntry("3", "Malcom", "ISBN 234234 Author: Arthur Machen"));
		books.add(new SearchTableEntry("4", "The Three Mosketeers", "Unknown data"));
		return books;
	}
}
