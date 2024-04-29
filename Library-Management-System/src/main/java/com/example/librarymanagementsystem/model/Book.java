package com.example.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
@Data
@Builder


@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;
    @NotNull
    private String author;
    private String isbn;
    private Integer publication_year;


}
