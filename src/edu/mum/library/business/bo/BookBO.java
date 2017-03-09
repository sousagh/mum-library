package edu.mum.library.business.bo;

import java.util.List;

import edu.mum.library.ui.util.SearchTableEntry;

public interface BookBO {

	List<SearchTableEntry> search(String name, String isbn, String author);

}
