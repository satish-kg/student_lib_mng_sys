package com.example.demo.Services;

import com.example.demo.DTOs.BookRequestDto;
import com.example.demo.DTOs.BookResponseDto;
import com.example.demo.Models.Author;
import com.example.demo.Models.Book;
import com.example.demo.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){
        Book book = new Book();
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setGenre(bookRequestDto.getGenre());
        book.setPages(bookRequestDto.getPages());

        int authorId = bookRequestDto.getAuthorId();
        Author author =  authorRepository.findById(authorId).get();

        book.setAuthor(author);

        List<Book> booksWrittenUpdated = author.getBooksWritten();
        booksWrittenUpdated.add(book);

        authorRepository.save(author);

        return "Book added successfully!!";

    }
}
