package com.commons.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commons.dao.AuthorDao;
import com.commons.dao.BookDao;
import com.commons.model.Author;
import com.commons.model.Books;

@Repository
@Transactional
public class ServicesDAOImpl implements ServicesDAO
{
	@Autowired
	BookDao bookDAO;
	
	
	@Autowired
	AuthorDao authorDao;
	
	public void addAuthor(Author author)
	{
		authorDao.addAuthor(author);
	}

	public List<Author> listAuthor()
	{
		return authorDao.listAuthor();
	}

	public void addBook(Books books)
	{
		bookDAO.addBook(books);
	}

	public List<Books> listBooks()
	{
		return bookDAO.listBooks();
	}
}
