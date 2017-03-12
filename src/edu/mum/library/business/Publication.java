package edu.mum.library.business;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;



@JsonTypeInfo(use = Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({@Type(value=Book.class)})
public class Publication implements Serializable {

	private static final long serialVersionUID = -4247133156571196244L;
	protected String title;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date date;
	protected int maxDays;
	protected boolean available;

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Publication() {
	}

	public int getMaxDays() {
		return this.maxDays;
	}

	public void setMaxDays(int maxDays) {
		this.maxDays = maxDays;
	}

	public void checkout(){
		this.available=false;
	}

	public Publication(String title, int maxDays){
		this.title=title;
		this.maxDays=maxDays;
		this.date=new Date();
		this.available=true;
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

	public boolean isAvailable() {
		return available;
	}




}
