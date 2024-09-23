/**
 *
 */
package no.hvl.dat152.rest.ws.service;

import no.hvl.dat152.rest.ws.exceptions.BookNotFoundException;
import no.hvl.dat152.rest.ws.model.Book;
import no.hvl.dat152.rest.ws.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;


	public Book updateBook(Book book) throws BookNotFoundException {
		findBookById(book.getId());
		return bookRepository.save(book);
	}

	public void deleteByISBN(String isbn) throws BookNotFoundException {
		Book book = findByISBN(isbn);
		bookRepository.delete(book);
	}


	public Book saveBook(Book book) {

		return bookRepository.save(book);

	}

	public List<Book> findAll() {

		return (List<Book>) bookRepository.findAll();

	}

	public Book findByISBN(String isbn) throws BookNotFoundException {

		Book book = null;
		try {
			book = bookRepository.findBookByISBN(isbn);
		} catch (Exception e) {
			throw new BookNotFoundException("Book with isbn = " + isbn + " not found!");
		}

		return book;
	}

	private Book findBookById(long id) throws BookNotFoundException {

		return bookRepository.findById(id)
		                     .orElseThrow(() -> new BookNotFoundException("Book with id = " + id + " not found!"));
	}

}
