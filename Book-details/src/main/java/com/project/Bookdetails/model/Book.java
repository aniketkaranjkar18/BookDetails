package com.project.Bookdetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "books")
@XmlRootElement(name = "book")
@XmlAccessorType (XmlAccessType.FIELD)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@XmlAttribute(name = "id")
	@Column(name = "book_id")
	@NotNull(message = "bookId is mandatory")
	private String bookId;
	
	@Column(name = "author" )
	private String author;
	
	@Column(name = "title")
	@NotBlank(message = "title is mandatory")
	private String title;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "price")
	@Positive
	@NotNull(message = "price is mandatory, price can only be a number greater than 0")
	private float price;
	
	@Column(name = "publish_date")
	@XmlElement(name = "publish_date")
	private String publishDate;
	
	@Column(name = "book_desc")
	@XmlElement(name = "description")
	private String bookDescription;
	
	public Book() {
	}
	
	public Book( String bookId, String author, String title, String genre, float price, String publishDate,
			String bookDescription) {
		this.bookId = bookId;
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.publishDate = publishDate;
		this.bookDescription = bookDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookId=" + bookId + ", author=" + author + ", title=" + title + ", genre=" + genre
				+ ", price=" + price + ", publishDate=" + publishDate + ", bookDescription=" + bookDescription + "]";
	}
	
}
