package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(int id, Book book);
    void deleteBook(int id);
    List<Book> getAllBooks();
}
