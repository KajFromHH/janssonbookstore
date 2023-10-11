package com.example.janssonbookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.janssonbookstore.domain.Book;
import com.example.janssonbookstore.domain.BookRepository;
import com.example.janssonbookstore.domain.Category;
import com.example.janssonbookstore.domain.CategoryRepository;

@SpringBootTest
public class JanssonbookstoreRepositoriesTest {
	@Autowired
	private BookRepository bkRepository;

	@Autowired
	private CategoryRepository cyRepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bkRepository.findByTitle("Lord of The Rings");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Lord of The Rings");
		assertThat(books.get(0).getCategory().getCategoryName()).isEqualTo("Fantasy");
	}
	// Hyvaksytty!

	@Test
	public void findByCategoryNameShouldReturnCategory() throws Exception {
		List<Category> categories = cyRepository.findByCategoryName("Science Fiction");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryName()).isEqualTo("Science Fiction");
	}
	// Hyvaksytty!

	@Test
	public void createNewBook() {
		Category category = new Category("Music");
		cyRepository.save(category);
		Book book = new Book("The Beatles' greatest hits", "Beatles Fan Community", category, "888-444-222", 1988, 5);
		bkRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	// Hyvaksytty!

	@Test
	public void deleteNewBook() {
		List<Book> books = bkRepository.findByTitle("Player Piano");
		bkRepository.delete(books.get(0));
		List<Book> newBooks = bkRepository.findByTitle("Player Piano");
		assertThat(newBooks).hasSize(0);

	}
	// Hyvaksytty!
}
