package com.lambdaschool.foundation.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Authors
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastname;

    private String firstname;


}
