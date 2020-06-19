package com.lambdaschool.foundation.models;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionkey;

    private String sectionname;

    
}
