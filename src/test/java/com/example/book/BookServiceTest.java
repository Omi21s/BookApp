package com.example.book;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.book.Repository.BookRepository;
import com.example.book.entity.Book;
import com.example.book.service.BookService;

@SpringBootTest
public class BookServiceTest {
	
	@Mock
	BookRepository bookRepo;
	
	@InjectMocks
	BookService bookService;
	
	
	
	@Test
	void addBookShouldAddBookSussfully() {
		
		Book b = new Book();
		b.setId(1);
		b.setTitle("HarryPotter");
		b.setAuthor("J K rolling");
		b.setGenre("xcv");
		
		System.out.println(b);
		
		Mockito.when(bookRepo.save(b)).thenReturn(b);
		
		Book addBook = bookService.addBook(b);
		
		Assertions.assertEquals(b.getId(),addBook.getId());
		//Assertions.assertEquals(b.getId(),addBook.getId());
		
	}

}
