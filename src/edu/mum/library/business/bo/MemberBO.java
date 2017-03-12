package edu.mum.library.business.bo;

import edu.mum.library.business.LibraryMember;

public interface MemberBO {

	void addMember(LibraryMember member);

	boolean exists(int memberNumber);

}
