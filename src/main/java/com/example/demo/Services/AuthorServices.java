package com.example.demo.Services;

import com.example.demo.DTOs.AuthorEntryDto;
import com.example.demo.DTOs.AuthorResponseDto;
import com.example.demo.DTOs.BookResponseDto;
import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServices {

    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor(AuthorEntryDto authorEntryDto){
        Author author = new Author();
        author.setName(authorEntryDto.getName());
        author.setCountry(authorEntryDto.getCountry());
        author.setAge(authorEntryDto.getAge());
        author.setRating(authorEntryDto.getRating());
        authorRepository.save(author);
        return "Author added successfully!!";
    }

    public AuthorResponseDto getAuthor(Integer authorId){
        Author author = authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setCountry(author.getCountry());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());

        List<Book> bookList = author.getBooksWritten();
        List<BookResponseDto> bookResponseDtoList = new ArrayList<>();

        for(Book book : bookList){
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setName(book.getName());
            bookResponseDto.setPages(book.getPages());
            bookResponseDto.setGenre(book.getGenre());
            bookResponseDtoList.add(bookResponseDto);
        }
        return authorResponseDto;
    }
}
