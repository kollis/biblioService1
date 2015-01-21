package com.sow.biblio.service.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BOOK", schema="SOWJANYA")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BOOK_ID_GENERATOR", sequenceName="SOWJANYA.BOOK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOOK_ID_GENERATOR")
	@Column(name="BOOK_ID")
	private long bookId;
	
	@Column(name="BOOK_NAME")
	private String bookName;
	
	@Column(name="AUTHOR_NAME")
	private String authorName;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="COST")
	private double cost;
	
	@Column(name="ADDED_DATE")
	private Calendar addedDate;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Calendar getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Calendar addedDate) {
		this.addedDate = addedDate;
	}
}