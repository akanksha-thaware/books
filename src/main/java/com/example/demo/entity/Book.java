package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@AllArgsConstructor
@Data
@NoArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "book_name")
    String bookName;

    @Column(name = "author_name")
    String authorName;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    double price;


}
