package edu.mum.library.business;

import java.util.HashMap;
import java.util.List;

import edu.mum.library.data.MemberDataAccess;
import edu.mum.library.data.impl.MemberDataAccessImpl;

public class LibraryFacade implements IActorsLogic,ICheckoutLogic {

	private List<LibraryMember> members;
	private List<Publication> publications;
	private List<User> users;
	private CheckoutRecord record;
	
	
	public List<LibraryMember> getMembers() {
		return members;
	}

	public void setMembers(List<LibraryMember> members) {
		this.members = members;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public CheckoutRecord getRecord() {
		return record;
	}

	public void setRecord(CheckoutRecord record) {
		this.record = record;
	}

	@Override
	public CheckoutItem search(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewCopy(String isbn) {
		
	}

	@Override
	public void checkout(CheckoutItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCopies(Book item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CheckoutRecord getMemberHistoricRecord(LibraryMember member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User Login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewMember(LibraryMember member) {
		MemberDataAccess da=new MemberDataAccessImpl();
		da.saveLibraryMember(member.getMemberNumber(), member);		
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	
}
