package com.example.Library.Book;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "AVAILABILITY")
    private int avail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }

    public Book() {
    }
}
