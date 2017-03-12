package edu.mum.library.business.bo;

import edu.mum.library.business.Publication;
import edu.mum.library.business.LibraryMember;

public interface MemberBO {

	void addMember(LibraryMember member);

	boolean exists(int memberNumber);
	
	LibraryMember findById(String memberId);
	
	void checkout(LibraryMember member,Publication publication);

}
