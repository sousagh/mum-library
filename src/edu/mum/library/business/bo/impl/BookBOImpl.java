package edu.mum.library.business.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.library.business.Author;
import edu.mum.library.business.Book;
import edu.mum.library.business.bo.BookBO;
import edu.mum.library.data.DataAccessObject;
import edu.mum.library.data.impl.DataObjectFactory;
import edu.mum.library.ui.util.SearchTableEntry;

public class BookBOImpl implements BookBO {

	BookBOImpl() {
	}

	@Override
	public List<SearchTableEntry> search(String name, String isbn, String author) {

		DataAccessObject dataAccessObject = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);
		/*Book book = new Book("Lord Of the Rings 2", "weq", null, 3);
		dataAccessObject.save("qwe", book);
		book = new Book("Os miseraveis", "1234", null, 3);
		dataAccessObject.save("q45we", book);*/

		Map<String, String> params = new HashMap<>();

		params.put("title", name);
		params.put("isbn", isbn);
		params.put("author", author);

		Set<Object> bookList = dataAccessObject.search(params, Book.class);
		List<SearchTableEntry> books = new ArrayList<>();
		for (Object object : bookList) {
			books.add(new SearchTableEntry((Book) object));
		}

		// books.add(new SearchTableEntry("1", "Lord Of the Rings", "ISBN 213131
		// Author: J. Tolkien"));
		// books.add(new SearchTableEntry("2", "Design Patterns", "ISBN 32442
		// Author: Marting Fowler"));
		// books.add(new SearchTableEntry("3", "Malcom", "ISBN 234234 Author:
		// Arthur Machen"));
		// books.add(new SearchTableEntry("4", "The Three Mosketeers", "Unknown
		// data"));
		return books;
	}

	@Override
	public Book findById(String id) {

		/*Author author = new Author();
		author.setName("JJ");
		author.setLastName("Tolkien");
		author.setBio("This is a small biografy about JJ Tolkien. See you later my friend.");
		author.setCredentials("ASDFGGFD-WER");
		Book book = new Book("Lord Of the Rings", "213131", author,7);*/
		DataAccessObject dataAccessObject = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);
		
		return null;
	}
}
