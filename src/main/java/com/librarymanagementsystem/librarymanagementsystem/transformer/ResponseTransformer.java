package com.librarymanagementsystem.librarymanagementsystem.transformer;

import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.AuthorResponse;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.Response;
import com.librarymanagementsystem.librarymanagementsystem.model.Author;

import java.util.Optional;

public class ResponseTransformer<T> {
    public static <T> Response<T> mapChildResponseToParentResponse(T childResponseDTO, String message, String... error) {
        return Response.<T>builder()
                .message(message)
                .error(error.length > 0 ? error[0]: "")
                .response(childResponseDTO)
                .build();
    }
}
