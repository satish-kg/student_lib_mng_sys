package com.example.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BookIssueRequestDto {

    private int bookId;
    private int cardId;
}
