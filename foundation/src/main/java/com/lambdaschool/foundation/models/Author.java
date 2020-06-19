package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String firstname;

    private String lastname;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "author", allowSetters = true)
    private List<Wrote> book  = new ArrayList<>();

    public Author()
    {
    }

    public Author(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
