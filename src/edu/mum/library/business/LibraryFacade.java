package edu.mum.library.business;

import java.util.HashMap;
import java.util.List;

public class LibraryFacade implements IActorsLogic,ICheckoutLogic {

	private List<LibraryMember> members;
	private List<Book> books;
	private List<Periodical> periodicals;
	private List<User> users;
	private CheckoutRecord record;
	
	public List<Periodical> getPeriodicals() {
		return periodicals;
	}

	public void setPeriodicals(List<Periodical> periodicals) {
		this.periodicals = periodicals;
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setItems(List<Book> books) {
		this.books = books;
	}
	
	
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
}
