package com.librarymanagementsystem.librarymanagementsystem.controller;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Genre;
import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.BookRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.AuthorResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.librarymanagementsystem.transformer.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Response<BookResponse>> addBook(@RequestBody BookRequest bookRequest) {
        try {
            BookResponse bookResponse = bookService.addBook(bookRequest);

            // adding that specific response DTO to parent (or) global response DTO
            Response<BookResponse> response= ResponseTransformer.mapChildResponseToParentResponse(bookResponse, "Book Added Successfully.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<BookResponse> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    @GetMapping("/get-boook-by-genre-and-cost")
    public ResponseEntity<Response<List<BookResponse>>> getBooksBygereAndCostGraterThan(@RequestParam Genre genre, @RequestParam  double cost) {
        try {
            List<BookResponse> bookResponses = bookService.getBooksBygereAndCostGraterThan(genre, cost);

            // adding that specific response DTO to parent (or) global response DTO
            Response<List<BookResponse>> response = ResponseTransformer.mapChildResponseToParentResponse(bookResponses, "Books Found!");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            Response<List<BookResponse>> errorResponse = ResponseTransformer.mapChildResponseToParentResponse(null, "", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
