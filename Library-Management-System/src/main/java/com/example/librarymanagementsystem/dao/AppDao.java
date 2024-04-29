package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Patron;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppDao {
    void addBook(Book book);
    void deleteBook(int id);
    void updateBook(int id, Book book);
    Book getBookById(int id);
    List<Book> getBooks();


    void addPatron(Patron patron);
    Patron getPatronById(int id);

    List<Patron> getPatrons();

    void updatePatron(int id, Patron patron);
    void deletePatron(int id);


    void patronBorrow(int patronId,int bookId);
    void returnBook(int patronId,int bookId);



}
