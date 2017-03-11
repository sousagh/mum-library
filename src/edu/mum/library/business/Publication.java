package edu.mum.library.business;

import java.io.Serializable;
import java.time.LocalDate;

public class Publication implements Serializable {

	private static final long serialVersionUID = -4247133156571196244L;
	protected String title;
	protected LocalDate date;

	public Publication() {

	}

	public Publication(String title){
		this.title=title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


}
