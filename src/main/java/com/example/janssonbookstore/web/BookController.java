package com.example.janssonbookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.janssonbookstore.domain.Book;
import com.example.janssonbookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	// List all books
	@RequestMapping(value = { "/booklist" })
	public String bookListFormat(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = { "/showaddbook" })
	public String showBookAddFormat(Book book, Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	// Add new book
	@RequestMapping(value = { "/add" })
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	// Save new or edited book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	// Edit current book
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		return "editbook";
	}

	// Delete books
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

}
