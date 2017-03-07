package edu.mum.library.business;

public interface IActorsLogic {
	public User Login(String username, String password);
	public void addNewMember(LibraryMember member);
}
