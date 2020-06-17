package com.example.Library.Issue;

import com.example.Library.Book.Book;
import com.example.Library.Book.BookRepo;
import com.example.Library.Exceptions.NotFoundException;
import com.example.Library.Functions;
import com.example.Library.User.User;
import com.example.Library.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IssueResource {

    @Autowired
    IssueRepo repo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    UserRepo userRepo;


    @GetMapping("/books_issued")
    public List<Issue> getAll(){
        List<Issue> issueList = repo.findAll();
        if (issueList.isEmpty())
            throw new NotFoundException();
        return issueList;
    }

    Functions f = new Functions();

    @PostMapping("/issue_book")
    public String addBook(@RequestBody Issue book_issued) {
        if (f.check(book_issued,bookRepo,userRepo)){
            repo.save(book_issued);
            return "Book issued" ;
        }

        return "Sorry, /n Book not issued" ;

    }

    @GetMapping("/return_book/{book_id}")
    public String returnAbook(@PathVariable int book_id){

        Issue data = repo.findByBookId(book_id);
        int user_id = data.getUser_id();

        System.out.println(book_id+ "    " + user_id);

        if(f.returnABook(data,repo,bookRepo,userRepo)){
            repo.deleteById(data.getId());
            return "Book Return Successful";
        }

        return "Sorry , Book Not Return";
    }

}
