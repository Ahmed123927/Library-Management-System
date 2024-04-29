package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.dao.AppDaoImplementation;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryManagementController {
   private  final AppDaoImplementation appDaoImplementation;

   @Autowired
    public LibraryManagementController(AppDaoImplementation appDaoImplementation) {
        this.appDaoImplementation = appDaoImplementation;
    }

    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        try {
            appDaoImplementation.addBook(book);
            return ResponseEntity.ok("Book added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add the book");
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(appDaoImplementation.getBookById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
        try {
            appDaoImplementation.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the book");
        }
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") int id,@RequestBody Book book){
        try {
            appDaoImplementation.updateBook(id,book);
            return ResponseEntity.ok("Book updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the book");
        }
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        try {
            return ResponseEntity.ok(appDaoImplementation.getBooks());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/patrons")
    public ResponseEntity<String> addPatron(@RequestBody Patron patron){
        try {
            appDaoImplementation.addPatron(patron);
            return ResponseEntity.ok("Patron added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add the patron");
        }
    }

    @GetMapping("/patrons/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(appDaoImplementation.getPatronById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/patrons")
    public ResponseEntity<List<Patron>> getPatrons(){
        try {
            return ResponseEntity.ok(appDaoImplementation.getPatrons());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/patrons/{id}")
    public ResponseEntity<String> updatePatron(@PathVariable("id") int id,@RequestBody Patron patron){
        try {
            appDaoImplementation.updatePatron(id,patron);
            return ResponseEntity.ok("Patron updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the patron");
        }
    }

    @DeleteMapping("/patrons/{id}")
    public ResponseEntity<String> deletePatron(@PathVariable("id") int id){
        try {
            appDaoImplementation.deletePatron(id);
            return ResponseEntity.ok("Patron deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the patron");
        }
    }

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<String> patronBorrow(@PathVariable("bookId") int bookId, @PathVariable("patronId") int patronId){
        try {
            appDaoImplementation.patronBorrow(patronId,bookId);
            return ResponseEntity.ok("Book borrowed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow the book");
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable("bookId") int bookId, @PathVariable("patronId") int patronId){
        try {
            appDaoImplementation.returnBook(patronId,bookId);
            return ResponseEntity.ok("Book returned successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to return the book");
        }
    }
}
