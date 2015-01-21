package com.sow.biblio.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sow.biblio.service.model.Book;
import com.sow.biblio.service.model.CustomBook;

@Service("bookService")
public class BookService extends BiblioServiceBaseAccessor implements IBookService {
	
	private static final Logger log = LoggerFactory.getLogger(BookService.class);

	public List<Book> findBook(String idStr, String name, String category, String author) {
		
		String query = "from Book where ";
		
		if (null != idStr && !idStr.isEmpty()) {
			query += " bookId = " + Integer.parseInt(idStr) + " and ";
		}
		
		if (null != name && !name.isEmpty()) {
			query += " lower(bookName) like '%" + name.toLowerCase() + "%' and ";
		}
		
		if (null != category && !category.isEmpty()) {
			query += " lower(category) like '%" + category.toLowerCase() + "%' and ";
		}
		
		if (null != author && !author.isEmpty()) {
			query += " lower(authorName) like '%" + author.toLowerCase() + "%' and ";
		}
		
		query = query.replaceFirst("(.*)and", "$1"); //remove the last 'and'
			
		TypedQuery<Book> q = em.createQuery(query, Book.class);
		List<Book> bookList = q.getResultList();
		
		log.debug("query:{}", query);
		
		return bookList;
	}
	
	public List<Book> getAllBooks() {
		
		List<Book> bookList = null;
		
		//String query= "from Book";
		//String query= "select b from Book b";
		String query= "select b.bookName from Book b";
		TypedQuery<Book> q = em.createQuery(query, Book.class);
		
		bookList = q.getResultList();
		
		return bookList;
	}
	
	public List<CustomBook> getSpecificColumnsAllBooks() {
		
		List<CustomBook> bookList = null;
		
		String query= "select new CustomBook(b.bookId, b.bookName) from Book b";
		TypedQuery<CustomBook> q = em.createQuery(query, CustomBook.class);
		
		bookList = q.getResultList();
		
		query= "select b.bookId, b.bookName from Book b";
		List<Object[]> list = em.createQuery(query).getResultList();
		for(Object[] obj : list){
	        System.out.println(obj[0]);
	        System.out.println(obj[1]);
	    }
		
		
		return bookList;
	}
}
