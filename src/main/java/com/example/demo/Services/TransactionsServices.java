package com.example.demo.Services;

import com.example.demo.DTOs.BookIssueRequestDto;
import com.example.demo.Enums.CardStatus;
import com.example.demo.Enums.TransactionStatus;
import com.example.demo.Models.Book;
import com.example.demo.Models.Card;
import com.example.demo.Models.Transactions;
import com.example.demo.Repositories.BookRepository;
import com.example.demo.Repositories.CardRepository;
import com.example.demo.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionsServices {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public  String issueBook(BookIssueRequestDto bookIssueRequestDto)throws Exception {


        int bookId = bookIssueRequestDto.getBookId();
        int cardId = bookIssueRequestDto.getCardId();

        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        Transactions transaction = new Transactions();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);

        if(book==null || book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }

        if(card==null || (card.getCardStatus()!= CardStatus.ACTIVATED)){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw  new Exception("Card is not valid");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        List<Transactions>transactionsList = book.getTransactionsList();
        transactionsList.add(transaction);
        book.setTransactionsList(transactionsList);

        List<Book>bookListForCard = card.getBooksIssued();
        bookListForCard.add(book);
        card.setBooksIssued(bookListForCard);

        for(Book b : bookListForCard){
            System.out.println(b.getName());
        }

        List<Transactions>transactionsListForCard = card.getTransactionsList();
        transactionsListForCard.add(transaction);
        card.setTransactionsList(transactionsListForCard);

        cardRepository.save(card);

        return "Book issued successfully.";
    }

    public String getTransactions(int bookId, int cardId){
        List<Transactions> transactionsList = transactionRepository.getTransactionsForBookAndCard(bookId, cardId);
        String transactionId = transactionsList.get(0).getTransactionId();
        return transactionId;
    }
}
