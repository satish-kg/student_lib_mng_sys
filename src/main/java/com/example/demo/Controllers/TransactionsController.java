package com.example.demo.Controllers;

import com.example.demo.Services.TransactionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("transactions")
public class TransactionsController {

    @Autowired
    TransactionsServices transactionsServices;

//    @PostMapping("")
}
