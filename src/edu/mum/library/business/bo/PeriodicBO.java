package edu.mum.library.business.bo;

import java.time.LocalDate;
import java.util.List;

import edu.mum.library.ui.util.SearchTableEntry;

public interface PeriodicBO {

	List<SearchTableEntry> search(String text, LocalDate value);

}
