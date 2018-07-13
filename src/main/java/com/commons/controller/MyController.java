package com.commons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.commons.model.Author;
import com.commons.model.Books;
import com.commons.services.ServicesDAO;

@Controller
@RequestMapping(value="/")
public class MyController
{
	@Autowired	
	ServicesDAO servicesDAO;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		//do whatever
		/* "foos" is the name of the property that we want to register a custom editor to
		 * you can set property name null and it means you want to register this editor for occurrences of Set class in * command object
		 */
		binder.registerCustomEditor(List.class, "authors", new CustomCollectionEditor(List.class) {
			@Override
			protected Object convertElement(Object element) {
				int id = Integer.parseInt(element.toString());
				Author foo = new Author();
				foo.setId(id);
				return foo;
			}
		});
	}


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homepage(ModelMap model)
	{

		ModelAndView andView=new ModelAndView("homepage");
		List<Books> books = servicesDAO.listBooks();
		//List<Author> authors = servicesDAO.listAuthor();
		//	andView.addObject("authorsdata", authors);
		andView.addObject("books", books);
		andView.addObject("book",new Books());
		return andView;
	}

	@ModelAttribute("authorsdata")
	public List<Author> initializeProfiles() {
		return servicesDAO.listAuthor();
	}

	/*add author*/
	@RequestMapping(value="/addauthor", method = RequestMethod.POST)
	public String addAuthor(@ModelAttribute("addauthor") Author author)
	{
		servicesDAO.addAuthor(author);
		return "redirect:/";
	}


	/*add book*/
	@RequestMapping(value="/addbooks", method=RequestMethod.POST)
	public String addBooks(@ModelAttribute("book") Books book, BindingResult result)
	{
		if(result.hasErrors())
		{
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("error--"+error);
			}

		}
		else
		{
			servicesDAO.addBook(book);
		}
		return "redirect:/";

	}


}
