package edu.mum.library.business;

import java.time.LocalDate;

public class Periodical extends CheckoutItem{
	private String name;
	private LocalDate publicationDate;
	
	public Periodical(String name, LocalDate date){
		this.name=name;
		this.publicationDate=date;
		this.available=true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}


}
