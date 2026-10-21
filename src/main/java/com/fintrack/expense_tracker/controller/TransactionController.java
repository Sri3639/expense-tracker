package com.fintrack.expense_tracker.controller;

import com.fintrack.expense_tracker.entity.Transaction;
import com.fintrack.expense_tracker.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return service.create(transaction);
    }

    // GET ALL
    @GetMapping
    public List<Transaction> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Transaction getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Transaction update(
            @PathVariable Long id,
            @RequestBody Transaction transaction) {

        return service.update(id, transaction);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        System.out.println("Transaction with ID deleted successfully");

        return "Transaction deleted successfully";
    }
}