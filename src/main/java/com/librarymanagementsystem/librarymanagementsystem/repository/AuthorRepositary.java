package com.librarymanagementsystem.librarymanagementsystem.repository;

import com.librarymanagementsystem.librarymanagementsystem.model.Author;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepositary  extends JpaRepository<Author, Integer> {
    Optional<Author> findByEmailId(String emailId);
}
