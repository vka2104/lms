package com.librarymanagementsystem.librarymanagementsystem.model;

import com.librarymanagementsystem.librarymanagementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cardNo;

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreationTimestamp
    Date issuDate;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "libraryCard", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
}
