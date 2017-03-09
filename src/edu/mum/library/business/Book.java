package edu.mum.library.business;

import java.util.ArrayList;
import java.util.List;

public class Book extends Publication{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6829734135257045285L;

	private String isbn;
	private int totalCopies;
	private int availableCopies;
	private List<Author> authors;
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
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
		totalCopies=availableCopies=1;
	}
	
	public void addAuthor(Author author){
		this.authors.add(author);
	}
	
	public void addCopy(){
		this.totalCopies++;
		this.availableCopies++;
	}	
	
	public void checkout(){
		if(this.availableCopies>0){
			this.availableCopies--;
		}
	}
	
	public boolean isAvailable(){
		if(this.availableCopies>0){
			return true;
		}else return false;
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
