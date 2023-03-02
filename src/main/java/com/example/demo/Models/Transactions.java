package com.example.demo.Models;

import com.example.demo.Enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fine;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    private String transactionId = UUID.randomUUID().toString();
    @CreationTimestamp
    private Date transactionDate;
    private boolean isIssueOperation;

}
