package com.example.Library.Book;

import com.example.Library.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class BookResource {

    @Autowired
    BookRepo repo;

    @GetMapping("/books")
    public List<Book> get() {

        List<Book> book_list = repo.findAll();

            if (book_list.isEmpty())
                throw new NotFoundException();
        return book_list;
    }

    @GetMapping("/available_books")
    public List<Book> getAvailableBooks(){
        return repo.availableBooks();
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        repo.save(book);
        return book;
    }

}
