package com.example.janssonbookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.janssonbookstore.domain.Book;
import com.example.janssonbookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping(value = { "/", "/booklist" })
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = { "/showaddbook" })
	public String bookAddFormat(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = { "/addbook" })
	public String bookAddFormat(Book book, Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

}
