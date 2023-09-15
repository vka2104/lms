package com.librarymanagementsystem.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Gender;
import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.StudentRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.StudentResponse;
import com.librarymanagementsystem.librarymanagementsystem.exception.StudentNotFoundException;
import com.librarymanagementsystem.librarymanagementsystem.model.LibraryCard;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;
import com.librarymanagementsystem.librarymanagementsystem.repository.StudentRepositary;
import com.librarymanagementsystem.librarymanagementsystem.service.StudentService;
import com.librarymanagementsystem.librarymanagementsystem.transformer.LibraryCardTransformer;
import com.librarymanagementsystem.librarymanagementsystem.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentImpl implements StudentService {
    @Autowired
    StudentRepositary studentRepositary;
    public StudentResponse addStudent(StudentRequest studentRequest) {
        //convert t DTO to model
        Student student = StudentTransformer.StudentRequstToStudnet(studentRequest);

        //prepares a library card for a student
        LibraryCard libraryCard = LibraryCardTransformer.prepareLibraryCard(student);

        //sets that generated library card to student
        student.setLibraryCard(libraryCard);

        Student res = studentRepositary.save(student);

        //convert model to specific response
        return StudentTransformer.StudentToStudentResponse(res);
    }

    public StudentResponse getStudent(int regNo) {
        Optional<Student> res = studentRepositary.findById(regNo);
        Student student = res.orElse(null);
        if(student == null) throw new StudentNotFoundException("Invalid Student Id");
        //convert model to specific response
        return StudentTransformer.StudentToStudentResponse(student);
    }
    public List<StudentResponse> getStudentByGender(Gender gender) {
        List<Student> students = studentRepositary.findByGender(gender);
        if(students == null || students.isEmpty()) throw new StudentNotFoundException("There is no"+gender+"Students in the college.");
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student: students) {
            studentResponseList.add(StudentTransformer.StudentToStudentResponse(student));
        }
        return studentResponseList;
    }
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepositary.findAll();
        if(students.isEmpty()) throw new StudentNotFoundException("There no student exist in the college.");
        return StudentTransformer.convertStudentListToStudentResponseList(students);
    }
    public StudentResponse updateStudentAge(int regNo, int age) {
        Optional<Student> studentOpt = studentRepositary.findById(regNo);
        if(studentOpt.isEmpty()) throw new StudentNotFoundException("Invalid Student Id");
        studentOpt.get().setAge(age);
        Student savedStudent = studentRepositary.save(studentOpt.get());
        return StudentTransformer.StudentToStudentResponse(savedStudent);
    }
    public String deleteStudent(int regNo) {
        boolean isStudentExist = isStudentExist(regNo);
        if(!isStudentExist) throw new StudentNotFoundException("Invalid Student Id");

        studentRepositary.deleteById(regNo);
        return "Student deleted Successfully.";
    }
    public boolean isStudentExist(int regNo) {
        return studentRepositary.existsById(regNo);
    }

}
