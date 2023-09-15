package com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequest {
    String title;

    int noOfPages;

    Genre genre;

    double cost;

    boolean issued;

    int authorId;

}
