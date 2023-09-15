package com.librarymanagementsystem.librarymanagementsystem.dto.requestDTO;

import com.librarymanagementsystem.librarymanagementsystem.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequest {
    String name;

    int age;

    String email;

    Gender gender;
}
