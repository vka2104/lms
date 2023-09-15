package com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO;

import com.librarymanagementsystem.librarymanagementsystem.Enum.TransactionStatus;
import com.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.librarymanagementsystem.model.LibraryCard;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransactionResponse {

    String transactionId;

    TransactionStatus transactionStatus;

    String bookName;

    String authorName;

    String studentName;

    String libraryCardNo;
}
