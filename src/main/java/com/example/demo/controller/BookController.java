package com.example.demo.controller;

import com.example.demo.dto.BookRequestDTO;
import com.example.demo.dto.BookResponseDTO;
import com.example.demo.service.BookService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;

    @GetMapping("/")
    public List<BookResponseDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/")
    public BookResponseDTO createBook(@RequestBody BookRequestDTO book){
       return bookService.createBook(book);
    }

    @PutMapping("/")
    public BookResponseDTO updateBook(@RequestParam int id, @RequestBody BookRequestDTO book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/")
    public void deleteBookById(@RequestParam int id){
        bookService.deleteBook(id);
    }
}
