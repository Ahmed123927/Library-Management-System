package com.example.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patron")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    private String address;
}
