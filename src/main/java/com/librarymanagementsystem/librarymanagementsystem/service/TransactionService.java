package com.librarymanagementsystem.librarymanagementsystem.service;

import com.librarymanagementsystem.librarymanagementsystem.Enum.TransactionStatus;
import com.librarymanagementsystem.librarymanagementsystem.dto.responseDTO.TransactionResponse;
import com.librarymanagementsystem.librarymanagementsystem.exception.BookNotAvailableException;
import com.librarymanagementsystem.librarymanagementsystem.exception.StudentNotFoundException;
import com.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.librarymanagementsystem.librarymanagementsystem.model.Student;
import com.librarymanagementsystem.librarymanagementsystem.model.Transaction;
import com.librarymanagementsystem.librarymanagementsystem.repository.BookRepositary;
import com.librarymanagementsystem.librarymanagementsystem.repository.StudentRepositary;
import com.librarymanagementsystem.librarymanagementsystem.repository.TransactionRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    StudentRepositary studentRepositary;

    @Autowired
    BookRepositary bookRepositary;

    @Autowired
    TransactionRepositary transactionRepositary;

    @Autowired
    JavaMailSender javaMailSender;

    public TransactionResponse issueBook(int bookId, int studentId) {
        Optional<Student> studentOpt = studentRepositary.findById(studentId);
        if(studentOpt.isEmpty()) throw new StudentNotFoundException("Student not found!");

        Optional<Book> bookOpt = bookRepositary.findById(bookId);
        if(bookOpt.isEmpty()) throw new BookNotAvailableException("Book not found");

        Book book = bookOpt.get();
        if(book.isIssued()) throw new BookNotAvailableException("Book not available");

        Student student = studentOpt.get();

        //create transaction
        Transaction transaction = Transaction.builder()
                .transactionId(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(student.getLibraryCard())
                .build();
        //saving transaction
        Transaction savedTransaction = transactionRepositary.save(transaction);
        //update book

        book.setIssued(true);
        book.getTransactions().add(savedTransaction);

        //card changes
        student.getLibraryCard().getTransactions().add(savedTransaction);
        //saving transaction to parent 1
       Book savedBook =  bookRepositary.save(book);
        //saving transaction to parent 2
        Student savedStudent = studentRepositary.save(student);

        // send an email
        String text = "Congrats !!." + savedStudent.getName()+ "You have been issued "+savedBook.getTitle()+" book.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("testemailvasanth@gmail.com");
        message.setTo(savedStudent.getEmail());
        message.setSubject("Issue Book Notification");
        message.setText(text);
        javaMailSender.send(message);

        return TransactionResponse.builder()
                .transactionId(savedTransaction.getTransactionId())
                .transactionStatus(savedTransaction.getTransactionStatus())
                .bookName(savedBook.getTitle())
                .authorName(savedBook.getAuthor().getName())
                .studentName(savedStudent.getName())
                .libraryCardNo(savedStudent.getLibraryCard().getCardNo())
                .build();
    }
}
