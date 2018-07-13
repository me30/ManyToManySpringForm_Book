package com.commons.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commons.model.Author;
import com.commons.model.Books;

@Repository
@Transactional
public class BookDaoImpl implements BookDao{
	@Autowired
	SessionFactory sessionFactory;

	public void addBook(Books books)
	{
		sessionFactory.getCurrentSession().save(books);
	}

	@Transactional
	public List<Books> listBooks()
	{
		return sessionFactory.getCurrentSession().createCriteria(Books.class).list();
	}

}
