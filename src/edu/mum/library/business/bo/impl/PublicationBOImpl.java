package edu.mum.library.business.bo.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.library.business.Publication;
import edu.mum.library.business.bo.PublicationBO;
import edu.mum.library.data.DataAccessObject;
import edu.mum.library.data.impl.DataObjectFactory;
import edu.mum.library.ui.util.SearchTableEntry;

public class PublicationBOImpl implements PublicationBO {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public List<SearchTableEntry> search(String text, LocalDate value) {

		DataAccessObject dataAccessObject = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);

		Map<String, String> params = new HashMap<>();

		params.put("title", text);

		if (value != null) {
			params.put("date", this.formatter.format(value));
		}

		Set<Object> bookList = dataAccessObject.search(params, Publication.class);
		List<SearchTableEntry> books = new ArrayList<>();
		for (Object object : bookList) {
			books.add(new SearchTableEntry((Publication) object));
		}
		return books;
	}

	@Override
	public Publication findById(String id) {

		DataAccessObject dataAccessObject = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);

		return (Publication) dataAccessObject.read(id, Publication.class);
	}

	@Override
	public List<SearchTableEntry> findAll() {
		DataAccessObject dao = (DataAccessObject) DataObjectFactory.getDataObject(DataAccessObject.class);

		List<Object> publicationList = dao.findAll(Publication.class);
		List<SearchTableEntry> books = new ArrayList<>();
		for (Object object : publicationList) {
			books.add(new SearchTableEntry((Publication) object));
		}
		return books;
	}

}
