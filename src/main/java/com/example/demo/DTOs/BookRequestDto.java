package com.example.demo.DTOs;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private int id;
    private String name;
    private int pages;
    private int authorId;
}
