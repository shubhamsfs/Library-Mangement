package com.example.Library.User;

import com.example.Library.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserRepo repo;

    @GetMapping("/users")
    public List<User> getAll(){
        List<User> user = repo.findAll();
        if (user.isEmpty())
            throw new NotFoundException();
        return user;
    }

    @PostMapping("/add_user")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User addBook(@RequestBody User user){
        repo.save(user);
        return user;
    }
}
