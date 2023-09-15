package com.librarymanagementsystem.librarymanagementsystem.transformer;

import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.BookRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.model.Book;

public class BookTransformer {
    public static Book BookRequestToBook(BookRequest bookRequest) {
        return Book.builder()
            .title(bookRequest.getTitle())
            .noOfPages(bookRequest.getNoOfPages())
            .genre(bookRequest.getGenre())
            .cost(bookRequest.getCost())
            .issued(bookRequest.isIssued())
            .build();
    }
    public static BookResponse BookToBookResponse(Book book) {
        return BookResponse.builder()
            .title(book.getTitle())
            .noOfPages(book.getNoOfPages())
            .genre(book.getGenre())
            .cost(book.getCost())
            .build();
    }
}
