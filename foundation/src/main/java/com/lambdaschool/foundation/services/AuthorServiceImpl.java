package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Author> findAll()
    {
        List<Author> list = new ArrayList<>();

        authorrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author save(Author author)
    {
        return null;
    }
}
