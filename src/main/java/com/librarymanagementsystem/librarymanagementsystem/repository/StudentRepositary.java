package com.librarymanagementsystem.librarymanagementsystem.repository;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Gender;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositary extends JpaRepository<Student, Integer> {
    List<Student> findByGender(Gender gender);

}
