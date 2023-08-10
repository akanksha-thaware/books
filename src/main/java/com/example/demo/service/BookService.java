package com.example.demo.service;

import com.example.demo.dto.BookRequestDTO;
import com.example.demo.dto.BookResponseDTO;

import java.util.List;

public interface BookService {
    BookResponseDTO createBook(BookRequestDTO bookDto);
    BookResponseDTO updateBook(int id, BookRequestDTO bookDto);
    void deleteBook(int id);
    List<BookResponseDTO> getAllBooks();
}
