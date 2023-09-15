package com.librarymanagementsystem.librarymanagementsystem.controller;

import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.TransactionResponse;
import com.librarymanagementsystem.librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue/book-id/{bookId}/student-id/{studentId}")
    public ResponseEntity issueBook(@PathVariable int bookId, @PathVariable int studentId) {
        try {
            TransactionResponse transactionResponse = transactionService.issueBook(bookId, studentId);
            return ResponseEntity.status(HttpStatus.OK).body(transactionResponse);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
