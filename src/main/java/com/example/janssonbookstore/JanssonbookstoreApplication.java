package com.example.janssonbookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.janssonbookstore.domain.AppUser;
import com.example.janssonbookstore.domain.AppUserRepository;
import com.example.janssonbookstore.domain.Book;
import com.example.janssonbookstore.domain.BookRepository;
import com.example.janssonbookstore.domain.Category;
import com.example.janssonbookstore.domain.CategoryRepository;

@SpringBootApplication
public class JanssonbookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(JanssonbookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JanssonbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bkRepository, CategoryRepository cyRepository,
			AppUserRepository auRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			cyRepository.save(new Category("Art"));
			cyRepository.save(new Category("Bibliography"));
			cyRepository.save(new Category("Fantasy"));
			cyRepository.save(new Category("History"));
			cyRepository.save(new Category("Romance"));
			cyRepository.save(new Category("Science Fiction"));

			log.info("save a couple of books");
			bkRepository.save(new Book("Lord of The Rings", "J.R.R.Tolkien",
					cyRepository.findByCategoryName("Fantasy").get(0), "975-952-80-8888-9", 1954, 30));
			bkRepository.save(new Book("Player Piano", "Kurt Vonnegut",
					cyRepository.findByCategoryName("Science Fiction").get(0), "988-944-73-7777-8", 1952, 18));

			// Create users, one admin/admin (has read, write and update rights) and
			// user/user (has only read rights). Used Jukka Juslin's StudentListSecured code
			// as the base.
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			auRepository.save(user1);
			auRepository.save(user2);

			log.info("fetch all books");
			for (Book book : bkRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
