package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.models.Book;

import java.util.List;

public interface AuthorService
{
    List<Author> findAll();

    Author save(Author author);
}
