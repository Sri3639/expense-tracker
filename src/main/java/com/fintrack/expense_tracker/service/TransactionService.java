package com.fintrack.expense_tracker.service;

import com.fintrack.expense_tracker.entity.Transaction;
import com.fintrack.expense_tracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Transaction create(Transaction transaction) {

        if (transaction.getAmount() <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        return repository.save(transaction);
    }

    // GET ALL
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    // GET BY ID
    public Transaction getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    // UPDATE
    public Transaction update(Long id, Transaction updatedTransaction) {

        Transaction existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existing.setType(updatedTransaction.getType());
        existing.setAmount(updatedTransaction.getAmount());
        existing.setDescription(updatedTransaction.getDescription());

        return repository.save(existing);
    }

    // DELETE
    public void delete(Long id) {

        Transaction existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        repository.delete(existing);
    }
}