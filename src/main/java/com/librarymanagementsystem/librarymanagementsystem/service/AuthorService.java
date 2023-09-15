package com.librarymanagementsystem.librarymanagementsystem.service;

import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.AuthorRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.AuthorResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.exception.AuthorNotFoundException;
import com.librarymanagementsystem.librarymanagementsystem.model.Author;
import com.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.librarymanagementsystem.repository.AuthorRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
   AuthorResponse addAuthor(AuthorRequest authorRequest);

    public AuthorResponse updateAuthorEmailId(int id, String emailId);

    public List<BookResponse> getBooksByAuthorEmailId(String emailId);
}


