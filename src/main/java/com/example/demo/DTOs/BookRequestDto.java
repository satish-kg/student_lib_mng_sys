package com.example.demo.DTOs;

import com.example.demo.Enums.Genre;
import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    private String name;
    private int pages;
    private int authorId;
    private Genre genre;
}
