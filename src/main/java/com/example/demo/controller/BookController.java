package com.example.demo.controller;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
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

    public List<ResponseDto> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PostMapping("/")
            public ResponseDto createBook(@RequestBody RequestDto book){
       return bookService.createBook(book);
    }

    @PutMapping("/")
        public ResponseDto updateBook(@RequestParam int id, @RequestBody RequestDto book){
            return bookService.updateBook(id, book);
        }

    @DeleteMapping("/")
    public void deleteBookById(@RequestParam int id){
        bookService.deleteBook(id);
    }
}
