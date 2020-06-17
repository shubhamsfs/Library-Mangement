package com.example.Library.Book;

import com.example.Library.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where b.avail > 0")
    List<Book> availableBooks();

    @Query("select b from Book b where b.id =:id")
    Book findBookById(int id);

}
