package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.repository.BookRepository;
import com.lambdaschool.foundation.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "sectionService")
public class SectionServiceImpl implements SectionService
{
    @Autowired
    private SectionRepository sectionrepos;


    @Override
    public List<Section> findAll()
    {
        List<Section> list = new ArrayList<>();

        sectionrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Section save(Section section)
    {
        return sectionrepos.save(section);
    }
}
