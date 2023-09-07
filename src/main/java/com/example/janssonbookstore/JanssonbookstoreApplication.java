package com.example.janssonbookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.janssonbookstore.domain.Book;
import com.example.janssonbookstore.domain.BookRepository;

@SpringBootApplication
public class JanssonbookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(JanssonbookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JanssonbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Book("John", "Johnson", "john@john.com"));
			repository.save(new Book("Katy", "Kateson", "kate@kate.com"));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
