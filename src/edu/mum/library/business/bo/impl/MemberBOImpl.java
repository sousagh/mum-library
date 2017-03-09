package edu.mum.library.business.bo.impl;

import edu.mum.library.business.LibraryMember;
import edu.mum.library.business.bo.MemberBO;
import edu.mum.library.data.MemberDataAccess;
import edu.mum.library.data.MemberDataAccessFacade;

public class MemberBOImpl implements MemberBO {

	MemberBOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addMember(LibraryMember member) {
		// TODO Auto-generated method stub
		MemberDataAccess mda=new MemberDataAccessFacade();
		mda.saveLibraryMember(member.getMemberNumber(), member);
	}

}
