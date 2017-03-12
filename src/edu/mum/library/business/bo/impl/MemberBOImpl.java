package edu.mum.library.business.bo.impl;

import edu.mum.library.business.Publication;
import edu.mum.library.business.CheckoutEntry;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.mum.library.business.Book;
import edu.mum.library.business.BookCopy;
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

	@Override
	public LibraryMember findById(String memberId) {
		DataAccessObject dao = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);
		return (LibraryMember) dao.read(memberId, LibraryMember.class);
	}

	@Override
	public void checkout(LibraryMember member,Publication publication) {
		CheckoutEntry entry=new CheckoutEntry(publication);
		member.getRecord().addCheckoutEntry(entry);
		DataAccessObject dao = (DataAccessObjectImpl) DataObjectFactory.getDataObject(DataAccessObject.class);
		dao.save(Integer.toString(member.getMemberNumber()),member);
		if(publication instanceof Book){
			Book book=(Book)publication;
			dao.save(book.getIsbn(), book);
		}else{
			dao.save(publication.getTitle()+new SimpleDateFormat("dd-MM-yyyy").format(publication.getDate()), publication);
		}
	}

}
