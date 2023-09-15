package com.librarymanagementsystem.librarymanagementsystem.transformer;

import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.StudentRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.StudentResponse;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentTransformer {
    public static Student StudentRequstToStudnet(StudentRequest studentRequest) {
        return Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }
    public static StudentResponse StudentToStudentResponse(Student student) {

        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardNo(student.getLibraryCard().getCardNo())
                .build();
    }
    public static List<StudentResponse> convertStudentListToStudentResponseList(List<Student> students) {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for(Student student: students) {
            studentResponseList.add(StudentToStudentResponse(student));
        }
        return studentResponseList;
    }
}
