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

    /**
 * Adds a new book to the library management system.
 * <p>
 * This method maps to a POST request to "/books". It receives a {@link Book} object in the request body
 * and attempts to add the book to the system by calling the {@code addBook} method in the {@code appDaoImplementation}.
 * If the addition is successful, it returns a success message. Otherwise, it returns an error message with an appropriate
 * HTTP status code.
 * </p>
 *
 * @param book The {@link Book} object representing the book to be added to the system.
 * @return A {@link ResponseEntity} object containing a success message if the book is added successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@PostMapping("/books")
public ResponseEntity<String> addBook(@RequestBody Book book){
    try {
        appDaoImplementation.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add the book");
    }
}

    /**
 * Retrieves a book from the library management system by its ID.
 * <p>
 * This method maps to a GET request to "/books/{id}". It retrieves a book from the system
 * based on the specified ID by calling the {@code getBookById} method in the {@code appDaoImplementation}.
 * If the retrieval is successful, it returns a {@link ResponseEntity} containing the book information.
 * If the specified book ID does not exist or an error occurs during the retrieval process, it returns
 * an error message with an appropriate HTTP status code.
 * </p>
 *
 * @param id The ID of the book to be retrieved.
 * @return A {@link ResponseEntity} object containing the book information if the retrieval is successful,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@GetMapping("/books/{id}")
public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
    try {
        return ResponseEntity.ok(appDaoImplementation.getBookById(id));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

    /**
 * Deletes a book from the library management system.
 * <p>
 * This method maps to a DELETE request to "/books/{id}". It attempts to delete a book identified by the specified ID
 * from the library's records. If the deletion is successful, it returns a success message. Otherwise, it returns an error
 * message with an appropriate HTTP status code.
 * </p>
 *
 * @param id The ID of the book to be deleted.
 * @return A {@link ResponseEntity} object containing a success message if the book is deleted successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@DeleteMapping("/books/{id}")
public ResponseEntity<String> deleteBook(@PathVariable("id") int id){
    try {
        appDaoImplementation.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the book");
    }
}
    /**
 * Updates the details of an existing book in the library management system.
 * <p>
 * This method maps to a PUT request to "/books/{id}". It receives a book's ID and a {@link Book} object with updated information
 * in the request body. The method attempts to update the book's details in the system by calling the {@code updateBook} method
 * in the {@code appDaoImplementation}. If the update is successful, it returns a success message. Otherwise, it returns an error
 * message with an appropriate HTTP status code.
 * </p>
 *
 * @param id The ID of the book to be updated.
 * @param book The {@link Book} object containing updated information.
 * @return A {@link ResponseEntity} object containing a success message if the book is updated successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@PutMapping("/books/{id}")
public ResponseEntity<String> updateBook(@PathVariable("id") int id, @RequestBody Book book){
    try {
        appDaoImplementation.updateBook(id, book);
        return ResponseEntity.ok("Book updated successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the book");
    }
}

    /**
 * Retrieves the list of all books from the library management system.
 * <p>
 * This method maps to a GET request to "/books". It retrieves the list of all books
 * stored in the system by calling the {@code getBooks} method in the {@code appDaoImplementation}.
 * If the retrieval is successful, it returns a {@link ResponseEntity} containing the list of books.
 * If an error occurs during the retrieval process, it returns an error message with an appropriate HTTP status code.
 * </p>
 *
 * @return A {@link ResponseEntity} object containing the list of all books if the retrieval is successful,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@GetMapping("/books")
public ResponseEntity<List<Book>> getBooks(){
    try {
        return ResponseEntity.ok(appDaoImplementation.getBooks());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

    /**
 * Adds a new patron to the library management system.
 * <p>
 * This method maps to a POST request to "/patrons". It receives a {@link Patron} object in the request body
 * and attempts to add the patron to the system by calling the {@code addPatron} method in the {@code appDaoImplementation}.
 * If the addition is successful, it returns a success message. Otherwise, it returns an error message with an appropriate
 * HTTP status code.
 * </p>
 *
 * @param patron The {@link Patron} object representing the patron to be added to the system.
 * @return A {@link ResponseEntity} object containing a success message if the patron is added successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@PostMapping("/patrons")
public ResponseEntity<String> addPatron(@RequestBody Patron patron){
    try {
        appDaoImplementation.addPatron(patron);
        return ResponseEntity.ok("Patron added successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add the patron");
    }
}

    /**
 * Retrieves a patron from the library management system by their ID.
 * <p>
 * This method maps to a GET request to "/patrons/{id}". It retrieves a patron from the system
 * based on the specified ID by calling the {@code getPatronById} method in the {@code appDaoImplementation}.
 * If the retrieval is successful, it returns a {@link ResponseEntity} containing the patron information.
 * If the specified patron ID does not exist or an error occurs during the retrieval process, it returns
 * an error message with an appropriate HTTP status code.
 * </p>
 *
 * @param id The ID of the patron to be retrieved.
 * @return A {@link ResponseEntity} object containing the patron information if the retrieval is successful,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@GetMapping("/patrons/{id}")
public ResponseEntity<Patron> getPatronById(@PathVariable("id") int id){
    try {
        return ResponseEntity.ok(appDaoImplementation.getPatronById(id));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

    /**
 * Retrieves the list of all patrons from the library management system.
 * <p>
 * This method maps to a GET request to "/patrons". It retrieves the list of all patrons
 * stored in the system by calling the {@code getPatrons} method in the {@code appDaoImplementation}.
 * If the retrieval is successful, it returns a {@link ResponseEntity} containing the list of patrons.
 * If an error occurs during the retrieval process, it returns an error message with an appropriate HTTP status code.
 * </p>
 *
 * @return A {@link ResponseEntity} object containing the list of all patrons if the retrieval is successful,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@GetMapping("/patrons")
public ResponseEntity<List<Patron>> getPatrons(){
    try {
        return ResponseEntity.ok(appDaoImplementation.getPatrons());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}

    /**
 * Updates the details of an existing patron in the library management system.
 * <p>
 * This method maps to a PUT request to "/patrons/{id}". It receives a patron's ID and a patron object with updated information.
 * The method attempts to update the patron's details in the system. If the update is successful, it returns a success message.
 * Otherwise, it returns an error message with an appropriate HTTP status code.
 * </p>
 *
 * @param id The ID of the patron to be updated.
 * @param patron The {@link Patron} object containing updated information.
 * @return A {@link ResponseEntity} object containing a success message if the patron is updated successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@PutMapping("/patrons/{id}")
public ResponseEntity<String> updatePatron(@PathVariable("id") int id, @RequestBody Patron patron){
    try {
        appDaoImplementation.updatePatron(id, patron);
        return ResponseEntity.ok("Patron updated successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the patron");
    }
}

    /**
 * Deletes a patron from the library management system.
 * <p>
 * This method maps to a DELETE request to "/patrons/{id}". It attempts to delete a patron identified by the specified ID
 * from the library's records. If the deletion is successful, it returns a success message. Otherwise, it returns an error
 * message with an appropriate HTTP status code.
 * </p>
 *
 * @param id The ID of the patron to be deleted.
 * @return A {@link ResponseEntity} object containing a success message if the patron is deleted successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@DeleteMapping("/patrons/{id}")
public ResponseEntity<String> deletePatron(@PathVariable("id") int id){
    try {
        appDaoImplementation.deletePatron(id);
        return ResponseEntity.ok("Patron deleted successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the patron");
    }
}

    /**
 * Allows a patron to borrow a book from the library.
 * <p>
 * This method maps to a POST request to "/borrow/{bookId}/patron/{patronId}". It attempts to process the borrowing of a book
 * by a patron by calling the {@code patronBorrow} method in the {@code appDaoImplementation}. This updates the system's records
 * to reflect that the book is currently borrowed by the specified patron.
 * </p>
 *
 * @param bookId The ID of the book being borrowed.
 * @param patronId The ID of the patron borrowing the book.
 * @return A {@link ResponseEntity} object containing a success message if the book is borrowed successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
@PostMapping("/borrow/{bookId}/patron/{patronId}")
public ResponseEntity<String> patronBorrow(@PathVariable("bookId") int bookId, @PathVariable("patronId") int patronId){
    try {
        appDaoImplementation.patronBorrow(patronId,bookId);
        return ResponseEntity.ok("Book borrowed successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow the book");
    }
}

    /**
 * Handles the return of a borrowed book by a patron.
 * <p>
 * This method maps to a PUT request to "/return/{bookId}/patron/{patronId}". It attempts to process the return of a book
 * that was borrowed by a patron. The method calls the {@code returnBook} method in the {@code appDaoImplementation} to
 * update the system's records, indicating that the book has been returned.
 * </p>
 *
 * @param bookId The ID of the book being returned.
 * @param patronId The ID of the patron returning the book.
 * @return A {@link ResponseEntity} object containing a success message if the book is returned successfully,
 *         or an error message with an appropriate HTTP status code if the operation fails.
 */
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
