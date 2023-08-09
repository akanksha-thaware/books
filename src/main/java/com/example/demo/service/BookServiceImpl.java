package com.example.demo.service;


import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Override
    public ResponseDto createBook(RequestDto bookDto) {
        Book newbook = new Book();
        newbook.setBookName(bookDto.getName());
        newbook.setAuthorName(bookDto.getAuthor());
        newbook.setDescription(bookDto.getDescription());
        newbook.setPrice(bookDto.getPrice());
        bookRepository.save(newbook);
        ResponseDto dto = new ResponseDto();
        dto.setId(newbook.getId());
        dto.setName(newbook.getBookName());
        dto.setDescription(newbook.getDescription());
        dto.setAuthor(newbook.getAuthorName());
        dto.setPrice(newbook.getPrice());
        return dto;
    }

    @Override
    public ResponseDto updateBook(int id, RequestDto book) {
        if(bookRepository.existsById(id)){
            Book oldbook = bookRepository.findById(id).get();
            oldbook.setId(id);
            oldbook.setBookName(book.getName());
            oldbook.setAuthorName(book.getAuthor());
            oldbook.setDescription(book.getDescription());
            oldbook.setPrice(book.getPrice());
            Book newbook = bookRepository.save(oldbook);
            return new ResponseDto(id, newbook.getBookName(), newbook.getAuthorName(), newbook.getDescription(),
                    newbook.getPrice());
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<ResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertentitytoDTO).collect(Collectors.toList());
    }
    public ResponseDto convertentitytoDTO(Book book){
        ResponseDto dto = new ResponseDto();
        dto.setId(book.getId());
        dto.setName(book.getBookName());
        dto.setAuthor(book.getAuthorName());
        dto.setDescription(book.getDescription());
        dto.setPrice(book.getPrice());
        return dto;
    }
}
