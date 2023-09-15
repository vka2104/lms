package com.librarymanagementsystem.librarymanagementsystem.controller;

import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.AuthorRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.AuthorResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.service.AuthorService;
import com.librarymanagementsystem.librarymanagementsystem.transformer.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping("/add")
    public ResponseEntity<Response<AuthorResponse>> addAuthor(@RequestBody AuthorRequest authorRequest) {
        try {
            AuthorResponse authorResponse = authorService.addAuthor(authorRequest);

            // adding that specific response DTO to parent (or) global response DTO
            Response<AuthorResponse> response= ResponseTransformer.mapChildResponseToParentResponse(authorResponse, "Author Added Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<AuthorResponse> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/update-email-id/{id}")
    public ResponseEntity<Response<AuthorResponse>> updateAuthorEmailId(@PathVariable int id, @RequestParam String emailId) {
        try {
            AuthorResponse authorResponse = authorService.updateAuthorEmailId(id, emailId);

            // adding that specific response DTO to parent (or) global response DTO
            Response<AuthorResponse> response= ResponseTransformer.mapChildResponseToParentResponse(authorResponse, "Author Email Id Updated Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<AuthorResponse> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    @GetMapping("/get-books-by-author-id")
    public ResponseEntity<Response<List<BookResponse>>> getBooksByAuthorEmailId(@RequestParam String emailId) {
        try {
            List<BookResponse> bookResponses = authorService.getBooksByAuthorEmailId(emailId);

            // adding that specific response DTO to parent (or) global response DTO
            Response<List<BookResponse>> response = ResponseTransformer.mapChildResponseToParentResponse(bookResponses, "Books Found!");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<List<BookResponse>> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
