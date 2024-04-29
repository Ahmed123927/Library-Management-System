package com.example.librarymanagementsystem.dao;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.BorrowingRecord;
import com.example.librarymanagementsystem.model.Patron;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppDaoImplementation implements AppDao{

    private final EntityManager entityManager;

    public AppDaoImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        Book book = entityManager.find(Book.class, id);

            entityManager.remove(book);

        }

    @Override
    @Transactional
    public void updateBook(int id, Book updatedBook) {
        Book existingBook = entityManager.find(Book.class, id);
        if (existingBook != null) {
            if (updatedBook.getTitle() != null) {
                existingBook.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getAuthor() != null) {
                existingBook.setAuthor(updatedBook.getAuthor());
            }
            if (updatedBook.getIsbn() != null) {
                existingBook.setIsbn(updatedBook.getIsbn());
            }
            if (updatedBook.getPublication_year() != null) {
                existingBook.setPublication_year(updatedBook.getPublication_year());
            }

            entityManager.merge(existingBook);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }




    @Override
    public Book getBookById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> getBooks() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    @Transactional
    public void addPatron(Patron patron) {
        entityManager.persist(patron);
    }

    @Override
    public Patron getPatronById(int id) {
        return entityManager.find(Patron.class, id);
    }

    @Override
    public List<Patron> getPatrons() {
        return entityManager.createQuery("  SELECT p FROM Patron p", Patron.class).getResultList();
    }

    @Override
    @Transactional
    public void updatePatron(int id, Patron patron) {
        Patron oldPatron = entityManager.find(Patron.class, id);
        if (oldPatron != null) {
            if (patron.getName()!= null) {
                oldPatron.setName(patron.getName());
            }
            if (patron.getEmail()!= null) {
                oldPatron.setEmail(patron.getEmail());
            }
            if (patron.getAddress()!= null) {
                oldPatron.setAddress(patron.getAddress());
            }

            entityManager.merge(oldPatron);
        }
        else {
            throw new IllegalArgumentException("Patron not found with id: " + id);
        }
    }

    @Override
    @Transactional
    public void deletePatron(int id) {
        Patron oldPatron = entityManager.find(Patron.class,id);
        entityManager.remove(oldPatron);
    }

    @Override
    @Transactional
    public void patronBorrow(int patronId,int bookId) {
        BorrowingRecord borrowingRecord=new BorrowingRecord();
        borrowingRecord.setPatron(entityManager.find(Patron.class,patronId));
        borrowingRecord.setBook(entityManager.find(Book.class,bookId));
        borrowingRecord.setBorrowDate( new Date());
        borrowingRecord.setReturnDate(null);
        entityManager.persist(borrowingRecord);
    }

    @Override
    @Transactional
    public void returnBook(int patronId, int bookId) {
    List<BorrowingRecord> borrowingRecords = entityManager.createQuery(
            "SELECT br FROM BorrowingRecord br WHERE br.patron.id = :patronId AND br.book.id = :bookId AND br.returnDate IS NULL",
            BorrowingRecord.class)
            .setParameter("patronId", patronId)
            .setParameter("bookId", bookId)
            .getResultList(); // This will get you a List<BorrowingRecord>

    if (!borrowingRecords.isEmpty()) {
        BorrowingRecord borrowingRecord = borrowingRecords.get(0); // Assuming there's only one active borrowing record per book per patron
        borrowingRecord.setReturnDate(new Date());
        entityManager.merge(borrowingRecord);
    } else {
        throw new IllegalArgumentException("No active borrowing record found for given patronId and bookId");
    }
}

}
