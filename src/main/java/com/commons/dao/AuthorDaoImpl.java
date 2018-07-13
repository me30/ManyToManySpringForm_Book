package com.commons.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commons.model.Author;

@Repository
@Transactional
public class AuthorDaoImpl  implements AuthorDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
	public void addAuthor(Author author)
	{	
		sessionFactory.getCurrentSession().save(author);	
	}


	public List<Author> listAuthor()
	{
		return sessionFactory.getCurrentSession().createCriteria(Author.class).list();
	}


	public Author findByID(int id) {
		return (Author) sessionFactory.getCurrentSession().get(Author.class, id);
	}

}
