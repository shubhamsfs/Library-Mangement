package com.example.Library.User;

import com.example.Library.Book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.id =:id")
    User findUserById(int id);
}
