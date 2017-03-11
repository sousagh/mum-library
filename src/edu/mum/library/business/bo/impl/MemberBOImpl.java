package edu.mum.library.business.bo.impl;

import edu.mum.library.business.LibraryMember;
import edu.mum.library.business.bo.MemberBO;
import edu.mum.library.data.DataAccessObject;
import edu.mum.library.data.impl.DataAccessObjectImpl;
import edu.mum.library.data.impl.DataObjectFactory;

public class MemberBOImpl implements MemberBO {

	MemberBOImpl() {
	}

	@Override
	public void addMember(LibraryMember member) {
		DataAccessObject mda = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);
		String id = new Integer(member.getMemberNumber()).toString();
		mda.save(id, member);

		member = (LibraryMember) mda.read(id, LibraryMember.class);
	}

}
