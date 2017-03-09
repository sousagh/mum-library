package edu.mum.library.business;

import java.util.ArrayList;
import java.util.List;

public class Book extends Publication{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6829734135257045285L;

	private String isbn;
	private List<CheckoutItem> copies;
	private List<Author> authors;
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Book(String title,String isbn,Author author){
		super(title);
		this.isbn=isbn;
		this.authors=new ArrayList<Author>();
		this.authors.add(author);
		this.copies=new  ArrayList<CheckoutItem>();
		CheckoutItem item=new CheckoutItem(this,1);
		this.copies.add(item);
	}
	
	public void addAuthor(Author author){
		this.authors.add(author);
	}
	
	public void addCopy(){
		int copies=this.copies.size();
		CheckoutItem item=new CheckoutItem(this,copies++);
		this.copies.add(item);
	}	
	
	public void checkout(){
	
	}
	
	public boolean isAvailable(){
		return true;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(super.title+", "+isbn+"\n");
		for(Author author:authors){
			sb.append(author.toString()+"\n");
		}
		return sb.toString();
	}
}
