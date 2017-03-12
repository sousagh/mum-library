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
		DataAccessObject dao = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);
		String id = new Integer(member.getMemberNumber()).toString();
		dao.save(id, member);

		member = (LibraryMember) dao.read(id, LibraryMember.class);
	}

	@Override
	public boolean exists(int memberNumber) {
		DataAccessObject dao = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);
		String id = new Integer(memberNumber).toString();
		LibraryMember member = (LibraryMember) dao.read(id, LibraryMember.class);

		return member != null;
	}

}
