package com.example.demo.Services;

import com.example.demo.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServices {

    @Autowired
    TransactionRepository transactionRepository;
}
