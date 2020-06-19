package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.models.Wrote;
import com.lambdaschool.foundation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        Book newBook = new Book();

        newBook.setBooktitle(book.getBooktitle());
        newBook.setCopy(book.getCopy());
        newBook.setISBN(book.getISBN());

        newBook.setSection(book.getSection());

        List<Wrote> newWrotes = new ArrayList<>();
        newBook.getWrotes().clear();


        for (Wrote w : book.getWrotes())
        {
            newWrotes.add(new Wrote(w.getAuthor(), newBook));

        }
        newBook.setWrotes(newWrotes);

        return bookrepos.save(newBook);
    }

    @Override
    public void delete(long id)
    {
        if (bookrepos.findById(id).isPresent())
        {
            bookrepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Order " + id + " Not Found ");
        }
    }


}
