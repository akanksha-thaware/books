package com.example.demo.service;


import com.example.demo.dto.BookRequestDTO;
import com.example.demo.dto.BookResponseDTO;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.addMappings(new PropertyMap<BookRequestDTO, Book>() {
            @Override
            protected void configure() {
                map().setBookName(source.getName());
                map().setAuthorName(source.getAuthor());
            }
        });
        modelMapper.addMappings(new PropertyMap<Book, BookResponseDTO>() {
            @Override
            protected void configure() {
                map().setName(source.getBookName());
                map().setAuthor(source.getAuthorName());
            }
        });
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookDto) {
        Book newbook = modelMapper.map(bookDto, Book.class);
        bookRepository.save(newbook);
        return modelMapper.map(newbook, BookResponseDTO.class);
    }

    @Override
    public BookResponseDTO updateBook(int id, BookRequestDTO bookDto) {
        if(bookRepository.existsById(id)){
            Book newbook = modelMapper.map(bookDto, Book.class);
            newbook.setId(id);
            bookRepository.save(newbook);
            return modelMapper.map(newbook, BookResponseDTO.class);
        }
        return null;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(this::convertEntityToDTO).collect(Collectors.toList());

    }
    public BookResponseDTO convertEntityToDTO(Book book){
        return modelMapper.map(book, BookResponseDTO.class);
    }
}
