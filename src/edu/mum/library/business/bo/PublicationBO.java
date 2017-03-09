package edu.mum.library.business.bo;

import java.time.LocalDate;
import java.util.List;

import edu.mum.library.business.Publication;
import edu.mum.library.ui.util.SearchTableEntry;

public interface PublicationBO {

	List<SearchTableEntry> search(String text, LocalDate value);

	Publication findById(String id);

}
