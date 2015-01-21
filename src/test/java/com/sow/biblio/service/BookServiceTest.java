package com.sow.biblio.service;

import java.util.List;

import javax.annotation.Resource;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sow.biblio.service.model.Book;

public class BookServiceTest extends AbstractBibilioServiceTestCase {
	
	@Resource
	private IBookService bookService;
	
	@Test
	public void insertBook() {
		
		String query = " insert into sowjanya.address (address_id, address1, address2, city, state, postal_code) values (6, 'test St', 'test 19', 'test city', 'test state', '00000')";
		
		em.createNativeQuery(query).executeUpdate();
		
		List<Book> bookList = bookService.findBook(null, "PaTrI", null, null);
		
		Assert.assertEquals(bookList.size(), 1);
	
	}
	
	@Test
	public void findBook() {
		
		List<Book> bookList = bookService.findBook(null, "PaTrI", null, null);
		
		Assert.assertEquals(bookList.size(), 1);
		
		System.out.println("\n*********Bookname returned:" + bookList.get(0).getBookName() + "*****\n");
		
	}

}
