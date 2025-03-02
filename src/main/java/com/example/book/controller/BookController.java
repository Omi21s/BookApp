package com.example.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.entity.Book;
import com.example.book.service.BookService;

@RestController
@RequestMapping("/book/v1")
public class BookController {
	
	private final BookService bookService ;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
	@PostMapping("/addbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		Book saveBook = bookService.addBook(book);
		
		return ResponseEntity.ok(saveBook);

	}
	
	@GetMapping("/getBook/{bookName}")
	public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String bookName ){
		Book bookByName = bookService.getBookByName(bookName);
		
		return ResponseEntity.ok(bookByName);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book){
		Book updateBook = bookService.updateBook(book, id);
		
		return ResponseEntity.ok(updateBook);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
		
		bookService.deleteBook(id);
		
		return ResponseEntity.ok().build();
		
	}

}
