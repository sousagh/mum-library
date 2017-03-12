package edu.mum.library.business;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Publication implements Serializable {

	private static final long serialVersionUID = -4247133156571196244L;
	protected String title;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date date;
	protected int maxDays;

	public Publication() {
	}

	public int getMaxDays() {
		return this.maxDays;
	}

	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}


	public Publication(String title, int maxDays){
		this.title=title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}




}
