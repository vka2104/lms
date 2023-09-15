package com.librarymanagementsystem.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Genre;
import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.BookRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.exception.AuthorNotFoundException;
import com.librarymanagementsystem.librarymanagementsystem.model.Author;
import com.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.librarymanagementsystem.repository.AuthorRepositary;
import com.librarymanagementsystem.librarymanagementsystem.repository.BookRepositary;
import com.librarymanagementsystem.librarymanagementsystem.service.BookService;
import com.librarymanagementsystem.librarymanagementsystem.transformer.BookTransformer;
import com.librarymanagementsystem.librarymanagementsystem.transformer.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookImpl implements BookService {
    @Autowired
    AuthorRepositary authorRepositary;

    @Autowired
    BookRepositary bookRepositary;
    public BookResponse addBook(BookRequest bookRequest) {
        Optional<Author> author = authorRepositary.findById(bookRequest.getAuthorId());
        if (author.isEmpty()) throw new AuthorNotFoundException("Invalid Author ID !");
        Author authorDetail = author.get();

        // Convert DTO to model
        Book book = BookTransformer.BookRequestToBook(bookRequest);
        book.setAuthor(authorDetail);

        authorDetail.getBooks().add(book);

        Author savedAuthor = authorRepositary.save(authorDetail);

        // convert model to response DTO

        // adding model data to specific response DTO
        // since the "savedAuthor" won't return specific book. that's why setting response value from entity class object.
        return BookTransformer.BookToBookResponse(book);
    }

    public List<BookResponse> getBooksBygereAndCostGraterThan(Genre genre, double cost) {
        List<Book> books = bookRepositary.getBooksBygereAndCostGraterThanHQL(genre, cost);

        // convert model to response DTO
        List<BookResponse> booksList = new ArrayList<>();
        for (Book book: books) {
            // adding model data to specific response DTO
            BookResponse bookResponse = BookTransformer.BookToBookResponse(book);
            booksList.add(bookResponse);
        }
        return booksList;
    }
}
