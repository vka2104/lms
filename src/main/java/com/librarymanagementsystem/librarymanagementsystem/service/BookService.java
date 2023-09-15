package com.librarymanagementsystem.librarymanagementsystem.service;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Genre;
import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.BookRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookResponse addBook(BookRequest bookRequest);
    List<BookResponse> getBooksBygereAndCostGraterThan(Genre genre, double cost);
}
