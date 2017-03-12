package edu.mum.library.business.bo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.library.business.Book;
import edu.mum.library.business.Publication;
import edu.mum.library.business.bo.PublicationBO;
import edu.mum.library.data.DataAccessObject;
import edu.mum.library.data.impl.DataObjectFactory;
import edu.mum.library.ui.util.SearchTableEntry;

public class PublicationBOImpl implements PublicationBO {

	@Override
	public List<SearchTableEntry> search(String text, LocalDate value) {

		DataAccessObject dataAccessObject = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);

		Map<String, String> params = new HashMap<>();

		params.put("title", text);
		// params.put("date", value.);

		Set<Object> bookList = dataAccessObject.search(params, Book.class);
		List<SearchTableEntry> books = new ArrayList<>();
		for (Object object : bookList) {
			books.add(new SearchTableEntry((Book) object));
		}
		List<SearchTableEntry> periodics = new ArrayList<>();
		periodics.add(new SearchTableEntry("1", "Times", "12/12/2004"));
		periodics.add(new SearchTableEntry("2", "Washington Post", "12/12/2004"));
		periodics.add(new SearchTableEntry("3", "Malcom", "12/12/2004"));
		periodics.add(new SearchTableEntry("4", "AUTO", "12/12/2004"));
		return periodics;
	}

	@Override
	public Publication findById(String id) {

		Publication publication = new Publication("Times",7);
		publication.setDate(LocalDate.now());
		return publication;
	}

}
