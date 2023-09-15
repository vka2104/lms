package com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AuthorResponse {
    String name;
    String emailId;
}
