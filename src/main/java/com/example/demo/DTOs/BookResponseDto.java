package com.example.demo.DTOs;

import com.example.demo.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {

    private String name;
    private int pages;
    private Genre genre;
}
