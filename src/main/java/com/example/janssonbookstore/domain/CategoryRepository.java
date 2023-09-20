package com.example.janssonbookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Note Long (capitalised L) instead 'long'. This is due Long can handle "null" values,
//which simple 'long' cannot.
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByCategoryName(String categoryName);

}
