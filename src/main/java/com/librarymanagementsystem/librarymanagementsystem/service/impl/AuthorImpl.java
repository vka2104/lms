package com.librarymanagementsystem.librarymanagementsystem.service.impl;

import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.AuthorRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.AuthorResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.BookResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.exception.AuthorNotFoundException;
import com.librarymanagementsystem.librarymanagementsystem.model.Author;
import com.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.librarymanagementsystem.repository.AuthorRepositary;
import com.librarymanagementsystem.librarymanagementsystem.service.AuthorService;
import com.librarymanagementsystem.librarymanagementsystem.transformer.AuthorTransformer;
import com.librarymanagementsystem.librarymanagementsystem.transformer.BookTransformer;
import com.librarymanagementsystem.librarymanagementsystem.transformer.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorImpl implements AuthorService {
    @Autowired
    AuthorRepositary authorRepositary;
    @Override
    public AuthorResponse addAuthor(AuthorRequest authorRequest) {
        // Convert DTO to model
        Author author = AuthorTransformer.AuthorRequestToAuthor(authorRequest);

        //saving author to DB
        Author savedAuthor = authorRepositary.save(author);

         // convert model to response DTO

        // adding model data to specific response DTO
        return AuthorTransformer.AuthorToAuthorResponse(savedAuthor);
    }


    public AuthorResponse updateAuthorEmailId(int id, String emailId) {
        Optional<Author> authorOpt = authorRepositary.findById(id);
        if(authorOpt.isEmpty()) throw new AuthorNotFoundException("Author does not exist.");
        Author authorData = authorOpt.get();
        authorData.setEmailId(emailId);
        Author updatedAuthor = authorRepositary.save(authorData);

        // convert model to response DTO
        // adding model data to specific response DTO
        return AuthorTransformer.AuthorToAuthorResponse(updatedAuthor);
    }

    public List<BookResponse> getBooksByAuthorEmailId(String emailId) {
        Optional<Author> authorOpt = authorRepositary.findByEmailId(emailId);
        if (authorOpt.isEmpty()) throw new AuthorNotFoundException("Author does not exist.");

        // convert model to response DTO

        // adding model data to specific response DTO
        List<Book> books = authorOpt.get().getBooks();
        if(books == null || books.isEmpty()) throw new AuthorNotFoundException("The author don't have any books.");
        List<BookResponse> booksResponseList = new ArrayList<>();
        for (Book book: books) {
            BookResponse bookResponse = BookTransformer.BookToBookResponse(book);
            booksResponseList.add(bookResponse);
        }
        return booksResponseList;
    }
}
