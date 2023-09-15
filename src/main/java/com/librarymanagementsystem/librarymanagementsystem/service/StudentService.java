package com.librarymanagementsystem.librarymanagementsystem.service;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Gender;
import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.StudentRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.StudentResponse;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    StudentResponse addStudent(StudentRequest studentRequest);
    StudentResponse getStudent(int regNo);
    List<StudentResponse> getStudentByGender(Gender gender);
    List<StudentResponse> getAllStudents();
    StudentResponse updateStudentAge(int regNo, int age);
    String deleteStudent(int regNo);
}
