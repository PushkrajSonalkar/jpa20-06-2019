package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Book;
import com.jpa.repository.BookJPARepo;

@RestController
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	BookJPARepo bjr;
	@GetMapping(value="/all")
	public List<Book> findAll()
	{
		return bjr.findAll();
	}
	
	@GetMapping(value ="/{name}")
	private Book findByName(@PathVariable final String name) 
	{
		return bjr.findByName(name);
	}
	
	@PostMapping(value ="/load")
	private Book load(@RequestBody final Book book) 
	{
		bjr.save(book);
		return bjr.findByName(book.getName());
	}
}
