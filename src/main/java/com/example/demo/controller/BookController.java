package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;

    @GetMapping("/")

    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PostMapping("/")
            public Book createBook(@RequestBody Book book){
       return bookService.createBook(book);
    }

    @PutMapping("/")
        public Book updateBook(@RequestParam int id, @RequestBody Book book){
            return bookService.updateBook(id, book);
        }

    @DeleteMapping("/")
    public void deleteBookById(@RequestParam int id){
        bookService.deleteBook(id);
    }
}
