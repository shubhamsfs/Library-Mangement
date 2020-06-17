package com.example.Library.User;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;


    @Column(name = "ISSUED")
    private int issue_count;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIssue_count() {
        return issue_count;
    }

    public void setIssue_count(int issue_count) {
        this.issue_count = issue_count;
    }

    public User() {
    }
}
