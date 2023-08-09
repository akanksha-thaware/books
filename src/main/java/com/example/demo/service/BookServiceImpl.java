package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Override
    public Book createBook(Book newbook) {
        bookRepository.save(newbook);
        return newbook;
    }

    @Override
    public Book updateBook(int id, Book oldbook) {
        if(bookRepository.existsById(id)){
            oldbook.setId(id);
            oldbook.setBookName(oldbook.getBookName());
            oldbook.setAuthorName(oldbook.getAuthorName());
            oldbook.setDescription(oldbook.getDescription());
            oldbook.setPrice(oldbook.getPrice());
            return bookRepository.save(oldbook);
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }
}
