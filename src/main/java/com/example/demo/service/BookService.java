package com.example.demo.service;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;

import java.util.List;

public interface BookService {
    ResponseDto createBook(RequestDto bookDto);
    ResponseDto updateBook(int id, RequestDto bookDto);
    void deleteBook(int id);
    List<ResponseDto> getAllBooks();
}
