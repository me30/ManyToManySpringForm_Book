package com.commons.dao;

import java.util.List;

import com.commons.model.Author;

public interface AuthorDao {
	public void addAuthor(Author author);
	public List<Author> listAuthor();
	
	public Author findByID(int id);
}
