package com.example.book.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.Repository.BookRepository;
import com.example.book.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public Book addBook(Book book) {

		return bookRepo.save(book);

	}

	public Book getBookByName(String name) {

		return bookRepo.findByTitle(name);
	}

	public Book updateBook(Book book, Integer id) {

		Book bookEntity = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

		bookEntity.setTitle(book.getTitle());
		bookEntity.setAuthor(book.getAuthor());
		bookEntity.setGenre(book.getGenre());

		return bookRepo.save(bookEntity);
		

	}
	
	
	public void deleteBook(Integer id) {
		
		bookRepo.deleteById(id);
		
	}

}
