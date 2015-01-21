package com.sow.biblio.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BOOK", schema="SOWJANYA")
public class CustomBook implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="BOOK_ID_GENERATOR", sequenceName="SOWJANYA.BOOK_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOOK_ID_GENERATOR")
	@Column(name="BOOK_ID")
	private long bookId;
	@Column(name="BOOK_NAME")
	private String bookName;
	
	public CustomBook(long bookId, String bookName) {
		this.bookId = bookId;
		this.bookName = bookName;
	}
	
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
}
