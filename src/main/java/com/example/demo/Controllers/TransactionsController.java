package com.example.demo.Controllers;

import com.example.demo.DTOs.BookIssueRequestDto;
import com.example.demo.Services.TransactionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionsServices transactionsServices;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody BookIssueRequestDto bookIssueRequestDto){
        try{
            return transactionsServices.issueBook(bookIssueRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId") Integer bookId, @RequestParam("cardId") Integer cardId){
        return transactionsServices.getTransactions(bookId, cardId);
    }
}
