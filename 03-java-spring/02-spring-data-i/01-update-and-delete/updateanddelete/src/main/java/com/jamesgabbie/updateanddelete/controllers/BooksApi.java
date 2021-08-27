package com.jamesgabbie.updateanddelete.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jamesgabbie.updateanddelete.models.Book;
import com.jamesgabbie.updateanddelete.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi (BookService bookService) {
		this.bookService = bookService;
	}
	
	//@GetMapping
	@RequestMapping("/api/books")
	public List <Book> index() {
		return bookService.allBooks();
	}
	
	//@PostMapping
	@RequestMapping(value="/api/books", method = RequestMethod.POST)
	public Book create(
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") Integer numberOfPages) {
		Book book = new Book (title, description, language, numberOfPages);
		return bookService.createBook(book);
	}
	
	//@GetMapping
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	//@DeleteMapping
	@RequestMapping(value= "/api/books/delete/{id}", method = RequestMethod.DELETE)
	public Book delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return null;
	}
	
	
	//@PutMapping
	@RequestMapping(value="/api/books/update/{id}", method = RequestMethod.PUT)
	public Book update(@PathVariable Long id, Book book) {
		return bookService.update(book);
	}
}
