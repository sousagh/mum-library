package edu.mum.library.business;

public class BookCopy extends CheckoutItem{
	private int copyNumber;
	private Book book;
	
	
	public BookCopy(Book b,int num){
		this.book=b;
		this.copyNumber=num;
		this.available=true;
	}

	public int getCopyNumber() {
		return copyNumber;
	}
	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
}
