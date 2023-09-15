package com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Response<T> {
    T response;
    String message;
    String error;
}
