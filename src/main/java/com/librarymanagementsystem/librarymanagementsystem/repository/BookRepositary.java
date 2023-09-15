package com.librarymanagementsystem.librarymanagementsystem.repository;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Genre;
import com.librarymanagementsystem.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositary extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book where genre = :genre and cost > :cost", nativeQuery = true)
    public List<Book> getBooksBygereAndCostGraterThan(String genre, double cost);

//    most prefered approch
    @Query(value = "select b from Book b where b.genre = :genre and b.cost > :cost")
    public List<Book> getBooksBygereAndCostGraterThanHQL(Genre genre, double cost);
}
