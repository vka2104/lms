package com.librarymanagementsystem.librarymanagementsystem.transformer;

import com.librarymanagementsystem.librarymanagementsystem.Enum.CardStatus;
import com.librarymanagementsystem.librarymanagementsystem.model.LibraryCard;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;

import java.util.UUID;

public class LibraryCardTransformer {
    public static LibraryCard prepareLibraryCard(Student student) {
        String cardNo = UUID.randomUUID().toString();
        return LibraryCard.builder()
                .cardNo(cardNo)
                .cardStatus(CardStatus.ACTIVE)
                .student(student).build();
    }
}
