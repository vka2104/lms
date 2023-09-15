package com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookResponse {
    String title;

    int noOfPages;

    Genre genre;

    double cost;
}
