package com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorRequest {
    String name;

    int age;

    String emailId;
}
