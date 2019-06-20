package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jpa.entity.Book;

@Component
public interface BookJPARepo extends JpaRepository<Book,Long>
{

	Book findByName(String name);

}
