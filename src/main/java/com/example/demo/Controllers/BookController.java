package com.example.demo.Controllers;

import com.example.demo.DTOs.BookRequestDto;
import com.example.demo.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServices bookServices;

    @PostMapping("/addBook")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookServices.addBook(bookRequestDto);
    }
}
