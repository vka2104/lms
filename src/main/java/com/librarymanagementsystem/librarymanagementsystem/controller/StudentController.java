package com.librarymanagementsystem.librarymanagementsystem.controller;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Gender;
import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.StudentRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.StudentResponse;
import com.librarymanagementsystem.librarymanagementsystem.service.StudentService;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;
import com.librarymanagementsystem.librarymanagementsystem.transformer.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("add-student")
    public ResponseEntity<Response<StudentResponse>> addStudent(@RequestBody StudentRequest studentRequest) {
        try {
            StudentResponse studentResponse = studentService.addStudent(studentRequest);

            // adding that specific response DTO to parent (or) global response DTO
            Response<StudentResponse> response= ResponseTransformer.mapChildResponseToParentResponse(studentResponse, "Student Saved Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<StudentResponse> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    @GetMapping("get-student")
    public ResponseEntity<Response<StudentResponse>> getStudent(@RequestParam int regNo) {
        try {
            StudentResponse studentResponse = studentService.getStudent(regNo);
            // adding that specific response DTO to parent (or) global response DTO
            Response<StudentResponse> response= ResponseTransformer.mapChildResponseToParentResponse(studentResponse, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<StudentResponse> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    @GetMapping("get-student-by-gender")
    public ResponseEntity<Response<List<StudentResponse>>> getStudentByGender(@RequestParam Gender gender) {
        try {
            List<StudentResponse> students = studentService.getStudentByGender(gender);
            // adding that specific response DTO to parent (or) global response DTO
            Response<List<StudentResponse>> responses = ResponseTransformer.mapChildResponseToParentResponse(students, "");
            return ResponseEntity.status(HttpStatus.OK).body(responses);
        } catch (Exception e) {
            Response<List<StudentResponse>> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    @GetMapping("get-all-students")
    public ResponseEntity<Response<List<StudentResponse>>> getAllStudents() {
        try {
            List<StudentResponse> students = studentService.getAllStudents();

            // adding that specific response DTO to parent (or) global response DTO
            Response<List<StudentResponse>> responses = ResponseTransformer.mapChildResponseToParentResponse(students, "");
            return ResponseEntity.status(HttpStatus.OK).body(responses);
        } catch (Exception e) {
            Response<List<StudentResponse>> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    @PutMapping("update-student-age")
    public ResponseEntity<Response<StudentResponse>> updateStudentAge(@RequestParam int regNo, @RequestParam int age) {
        try {
            StudentResponse studentResponse = studentService.updateStudentAge(regNo, age);
            // adding that specific response DTO to parent (or) global response DTO
            Response<StudentResponse> response= ResponseTransformer.mapChildResponseToParentResponse(studentResponse, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<StudentResponse> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
    @DeleteMapping("delete-student")
    public ResponseEntity<Response<String>> deleteStudent(@RequestParam int regNo) {
        try {
            String res = studentService.deleteStudent(regNo);
            // adding that specific response DTO to parent (or) global response DTO
            Response<String> response= ResponseTransformer.mapChildResponseToParentResponse(res, "");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<String> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

}

