package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookrepos;

    @Override
    public List<Book> findAll()
    {
        List<Book> list = new ArrayList<>();

        bookrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book save(Book book)
    {
        return null;
    }

}
