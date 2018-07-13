package com.commons.services;

import java.util.List;

import com.commons.model.Author;
import com.commons.model.Books;

public interface ServicesDAO
{
	public void addAuthor(Author author);
	public void addBook(Books books);
	public List<Author> listAuthor();
	public List<Books> listBooks();
}
