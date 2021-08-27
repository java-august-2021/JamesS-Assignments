package com.jamesgabbie.updateanddelete.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jamesgabbie.updateanddelete.models.Book;
import com.jamesgabbie.updateanddelete.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
		
		public BookService(BookRepository bookRepository) {
			this.bookRepository = bookRepository;
			
		}
		
		public Book createBook(Book b) {
			return bookRepository.save(b);
		}
		
		public List<Book> allBooks() {
			return bookRepository.findAll();
		}
		
		public Book findBook(Long id) {
			Optional<Book> optionalBook = bookRepository.findById(id);
			if(optionalBook.isPresent()) {
				return optionalBook.get();
			} else {
				return null;
			}	
		}
		
		
		public void deleteBook(Long id) {
			bookRepository.deleteById(id);
			
		}
		
		public Book update(Book b) {
			return bookRepository.save(b);
		}
		
		
	

}
