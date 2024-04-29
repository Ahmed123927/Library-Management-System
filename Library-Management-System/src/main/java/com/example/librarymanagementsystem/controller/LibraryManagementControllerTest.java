package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.dao.AppDaoImplementation;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryManagementControllerTest {

    @Mock
    private AppDaoImplementation appDaoImplementation;

    @InjectMocks
    private LibraryManagementController libraryManagementController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addBook() {
        Book book = new Book();
        Mockito.doNothing().when(appDaoImplementation).addBook(book);
        ResponseEntity<String> response = libraryManagementController.addBook(book);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book added successfully", response.getBody());
    }

    @Test
    void getBookById() {
        int id = 1;
        Book book = new Book();
        Mockito.when(appDaoImplementation.getBookById(id)).thenReturn(book);
        ResponseEntity<Book> response = libraryManagementController.getBookById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
    }

    @Test
    void deleteBook() {
        int id = 1;
        Mockito.doNothing().when(appDaoImplementation).deleteBook(id);
        ResponseEntity<String> response = libraryManagementController.deleteBook(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book deleted successfully", response.getBody());
    }

    @Test
    void updateBook() {
        int id = 1;
        Book book = new Book();
        Mockito.doNothing().when(appDaoImplementation).updateBook(id, book);
        ResponseEntity<String> response = libraryManagementController.updateBook(id, book);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book updated successfully", response.getBody());
    }

    @Test
    void getBooks() {
        List<Book> books = new ArrayList<>();
        Mockito.when(appDaoImplementation.getBooks()).thenReturn(books);
        ResponseEntity<List<Book>> response = libraryManagementController.getBooks();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(books, response.getBody());
    }

    @Test
    void addPatron() {
        Patron patron = new Patron();
        Mockito.doNothing().when(appDaoImplementation).addPatron(patron);
        ResponseEntity<String> response = libraryManagementController.addPatron(patron);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Patron added successfully", response.getBody());
    }

    @Test
    void getPatronById() {
        int id = 1;
        Patron patron = new Patron();
        Mockito.when(appDaoImplementation.getPatronById(id)).thenReturn(patron);
        ResponseEntity<Patron> response = libraryManagementController.getPatronById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patron, response.getBody());
    }

    @Test
    void getPatrons() {
        List<Patron> patrons = new ArrayList<>();
        Mockito.when(appDaoImplementation.getPatrons()).thenReturn(patrons);
        ResponseEntity<List<Patron>> response = libraryManagementController.getPatrons();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patrons, response.getBody());
    }

    @Test
    void updatePatron() {
        int id = 1;
        Patron patron = new Patron();
        Mockito.doNothing().when(appDaoImplementation).updatePatron(id, patron);
        ResponseEntity<String> response = libraryManagementController.updatePatron(id, patron);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Patron updated successfully", response.getBody());
    }

    @Test
    void deletePatron() {
        int id = 1;
        Mockito.doNothing().when(appDaoImplementation).deletePatron(id);
        ResponseEntity<String> response = libraryManagementController.deletePatron(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Patron deleted successfully", response.getBody());
    }

    @Test
    void patronBorrow() {
        int bookId = 1;
        int patronId = 1;
        Mockito.doNothing().when(appDaoImplementation).patronBorrow(patronId, bookId);
        ResponseEntity<String> response = libraryManagementController.patronBorrow(bookId, patronId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book borrowed successfully", response.getBody());
    }

    @Test
    void returnBook() {
        int bookId = 1;
        int patronId = 1;
        Mockito.doNothing().when(appDaoImplementation).returnBook(patronId, bookId);
        ResponseEntity<String> response = libraryManagementController.returnBook(bookId, patronId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book returned successfully", response.getBody());
    }
}