package com.example.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public Book findByTitle(String title);

}
