package com.commons.dao;

import java.util.List;

import com.commons.model.Author;
import com.commons.model.Books;

public interface BookDao
{
	
	public void addBook(Books books);
	public List<Books> listBooks();
}
