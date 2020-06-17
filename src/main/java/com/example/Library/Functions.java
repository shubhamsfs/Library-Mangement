package com.example.Library;

import com.example.Library.Book.Book;
import com.example.Library.Book.BookRepo;
import com.example.Library.Issue.Issue;
import com.example.Library.Issue.IssueRepo;
import com.example.Library.User.User;
import com.example.Library.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Functions {

    Book book;
    User user;

    public Functions() {
    }


    public boolean check(Issue issue,BookRepo bookRepo, UserRepo userRepo){
        book = bookRepo.findBookById(issue.getBook_id());
        user = userRepo.findUserById(issue.getUser_id());

        if (book == null || user == null)
            return false;

        if (book.getAvail() <= 0 || user.getIssue_count() >= 2){
            return false;
        }

        book.setAvail(book.getAvail()-1);
        user.setIssue_count(user.getIssue_count()+1);

        return true;
    }

    public boolean returnABook(Issue data,IssueRepo issueRepo,BookRepo bookRepo, UserRepo userRepo){
        // write returning book code

//        issueRepo.cleardataentry(book_id,user_id);

        book = bookRepo.findBookById(data.getBook_id());
        user = userRepo.findUserById(data.getUser_id());

        if (book.getAvail() <= 0 || user.getIssue_count() >= 2){
            return false;
        }

        book.setAvail(book.getAvail()+1);
        user.setIssue_count(user.getIssue_count()-1);

        return true;
    }
}
