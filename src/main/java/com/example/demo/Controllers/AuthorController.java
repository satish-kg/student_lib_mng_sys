package com.example.demo.Controllers;

import com.example.demo.DTOs.AuthorEntryDto;
import com.example.demo.DTOs.AuthorResponseDto;
import com.example.demo.Services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorServices authorServices;

    @PostMapping("/addAuthor")
    public String addAuthor (@RequestBody AuthorEntryDto authorEntryDto){
        return authorServices.addAuthor(authorEntryDto);
    }

    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId")Integer authorId){
        return authorServices.getAuthor(authorId);
    }
}
