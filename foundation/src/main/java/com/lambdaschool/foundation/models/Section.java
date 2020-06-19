package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false)
    private String sectionname;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "section", allowSetters = true)
    private List<Book> book = new ArrayList<>();

    public Section()
    {
    }

    public Section(String sectionname)
    {
        this.sectionname = sectionname;
    }



}
