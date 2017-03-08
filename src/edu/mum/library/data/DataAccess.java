package edu.mum.library.data;

import edu.mum.library.business.LibraryMember;

public interface DataAccess {
	public void saveLibraryMember(int memberNumber,LibraryMember member);
	public LibraryMember readLibraryMember(int memberNumber);
}
