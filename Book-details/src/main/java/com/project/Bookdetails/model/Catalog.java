package com.project.Bookdetails.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "catalog")
@XmlAccessorType (XmlAccessType.FIELD)
public class Catalog {
	
	@XmlElement(name = "book")
	private List<Book> books;

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Catalog() {
		super();
	}

	public Catalog(List<Book> books) {
		super();
		this.books = books;
	}
  
	public List<Book> getBooks() {
		return books;
	}


	@Override
	public String toString() {
		return "Catalog [books=" + books + "]";
	}
}
