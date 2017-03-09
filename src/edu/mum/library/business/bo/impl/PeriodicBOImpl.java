package edu.mum.library.business.bo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.mum.library.business.bo.PeriodicBO;
import edu.mum.library.ui.util.SearchTableEntry;

public class PeriodicBOImpl implements PeriodicBO {

	@Override
	public List<SearchTableEntry> search(String text, LocalDate value) {
		List<SearchTableEntry> periodics = new ArrayList<>();
		periodics.add(new SearchTableEntry("1", "Times", "12/12/2004"));
		periodics.add(new SearchTableEntry("2", "Washington Post", "12/12/2004"));
		periodics.add(new SearchTableEntry("3", "Malcom", "12/12/2004"));
		periodics.add(new SearchTableEntry("4", "AUTO", "12/12/2004"));
		return periodics;
	}

}
