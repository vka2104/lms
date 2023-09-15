package com.librarymanagementsystem.librarymanagementsystem.transformer;

import com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO.AuthorRequest;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.AuthorResponse;
import com.librarymanagementsystem.librarymanagementsystem.model.Author;

public class AuthorTransformer {
    public static Author AuthorRequestToAuthor(AuthorRequest authorRequest) {
        return Author.builder()
            .name(authorRequest.getName())
            .age(authorRequest.getAge())
            .emailId(authorRequest.getEmailId())
            .build();
    }
    public static AuthorResponse AuthorToAuthorResponse(Author author) {
        return AuthorResponse.builder()
                .name(author.getName())
                .emailId(author.getEmailId())
                .build();
    }
}
