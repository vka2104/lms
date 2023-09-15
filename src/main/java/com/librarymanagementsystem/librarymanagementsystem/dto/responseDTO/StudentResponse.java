package com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {
    String name;

    String email;

    String libraryCardNo;

}
