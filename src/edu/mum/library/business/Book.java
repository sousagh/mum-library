package edu.mum.library.business;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book extends Publication{

	private static final long serialVersionUID = -6829734135257045285L;

	private String isbn;
	private List<BookCopy> copies;
	private List<Author> authors;

	public Book() {

	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Book(String title,String isbn,Author author, int days){
		super(title,days);
		this.isbn=isbn;
		this.authors=new ArrayList<Author>();
		this.authors.add(author);
		this.setCopies(new  ArrayList<BookCopy>());
		BookCopy item=new BookCopy(1);
		this.getCopies().add(item);
	}

	public void addAuthor(Author author){
		this.authors.add(author);
	}

	public void addCopy(){
		int copies=this.getCopies().size();
		BookCopy item=new BookCopy(copies+1);
		this.getCopies().add(item);
	}

	@Override
	public void checkout(){
		for(BookCopy copy:this.getCopies()){
			if(copy.isAvailable()){
				copy.setAvailable(false);
				break;
			}
		}
	}

	@Override
	@JsonIgnore
	public boolean isAvailable(){
		boolean aux=false;
		for(BookCopy copy:this.getCopies()){
			if(copy.isAvailable()){
				aux=true;
			}
		}
		this.available=aux;
		return this.available;
	}

	@JsonIgnore
	public int getAvailableCopies(){
		int sum=0;
		for(BookCopy copy:this.getCopies()){
			if(copy.isAvailable()){
				sum++;
			}
		}
		return sum;
	}

	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append(super.title+", "+this.isbn+"\n");
		for(Author author:this.authors){
			sb.append(author.toString()+"\n");
		}
		return sb.toString();
	}

	public List<BookCopy> getCopies() {
		return this.copies;
	}

	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}
}
