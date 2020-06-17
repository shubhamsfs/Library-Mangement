package com.example.Library.Issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IssueRepo extends JpaRepository<Issue,Integer> {

//    @Transactional
//    @Modifying
//    @Query("delete from Issue where user_id=:u_id AND book_id=:b_id")
//    Void cleardataentry(int b_id, int u_id);


    @Query("select i from Issue i  where i.book_id=:b_id")
    Issue findByBookId(int b_id);
}
