package edu.mum.library.business.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

		Map<String, String> params = new HashMap<>();

		params.put("title", name);
		params.put("isbn", isbn);
		params.put("authors", author);

		Set<Object> bookList = dataAccessObject.search(params, Book.class);
		List<SearchTableEntry> books = new ArrayList<>();
		for (Object object : bookList) {
			books.add(new SearchTableEntry((Book) object));
		}

		return books;
	}

	@Override
	public Book findById(String id) {

		DataAccessObject dataAccessObject = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);

		return (Book) dataAccessObject.read(id, Book.class);
	}

	@Override
	public List<SearchTableEntry> findAll() {
		DataAccessObject dao = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);

		List<Object> bookList = dao.findAll(Book.class);
		List<SearchTableEntry> books = new ArrayList<>();
		for (Object object : bookList) {
			books.add(new SearchTableEntry((Book) object));
		}
		return books;
	}
}
