package edu.mum.library.business;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String title;
	private String isbn;
	private List<Author> authors;
	private List<BookCopy> copies;
	
	
	public Book(String title,String isbn,Author author){
		this.title=title;
		this.isbn=isbn;
		this.authors=new ArrayList<Author>();
		this.authors.add(author);
		new BookCopy(this,1);
	}
	
	public void addAuthor(Author author){
		this.authors.add(author);
	}
	
	public void addCopy(BookCopy bc){
		this.copies.add(bc);
	}	
	
	public boolean isAvailable(){
		for(BookCopy copy:copies){
			if(copy.isAvailable()){
				return true;
			}
		}
		return false;
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(title+", "+isbn+"\n");
		for(Author author:authors){
			sb.append(author.toString()+"\n");
		}
		return sb.toString();
	}
}
